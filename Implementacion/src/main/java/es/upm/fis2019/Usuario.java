package es.upm.fis2019;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Usuario implements IUsuario, IRecuperador, IPublicador, Iborrable, IVerificable{
    private String alias;
    private String correo;
    private String contraseña;
    private IEjecutador accesobd;
    private List<IPublicacion> publicaciones;

    public Usuario(String alias, String correo, String contraseña) {
        this.alias = alias;
        this.correo = correo;
        this.contraseña = contraseña;
        publicaciones=new ArrayList<IPublicacion>();

    }

    @Override
    public String getAlias() { return alias; }

    @Override
    public String getCorreo() { return correo; }


    //metodos que procesan el result set y crean la lista de publicaciones de el
    @Override
    public List<IPublicacion> GetPublicacionesTimeline() {
        accesobd=Conexion.getInstance();
        ArrayList<IPublicacion> publicaciones;
        String query = "SELECT u_id as Usuario, p_id as Publicacion, likes, dislikes, fecha, contenido, tipo\n" +
                "FROM\n" +
                "\t(Select p_id, u_id\n" +
                "\tFROM publica INNER JOIN (SELECT alias2\n" +
                "\tFROM sigue\n" +
                "\tWHERE alias1 = \""+this.alias+"\") ON u_id = alias2) AS pU\n" +
                "\tINNER JOIN publicacion ON p_id = id\n" +
                "ORDER BY fecha DESC;";
        accesobd.conectar();
        ResultSet result= accesobd.ejecutarQuery(query);
        publicaciones = ObtTimeline(result);
        accesobd.desconectar();
        return publicaciones;
    }

    private ArrayList<IPublicacion> ObtTimeline(ResultSet rs){
        ArrayList<IPublicacion> publicaciones = new ArrayList<>();

        try {
            while (rs.next()){
                Publicacion p;
                String Autor = rs.getString(1);
                String IdPubli = rs.getString(2);
                String contenido = rs.getString(6);
                int likes = rs.getInt(3);
                int dislikes = rs.getInt(4);
                String fecha = rs.getString(5);
                String tipo = rs.getString(7);

                switch (tipo){
                    case ("texto"):
                        p = new PublicacionTexto(IdPubli,likes,dislikes,fecha,contenido);
                        p.setAutor(Autor);
                        publicaciones.add(p);
                        break;

                    case ("enlace"):
                        p = new PublicacionEnlace(IdPubli,likes,dislikes,fecha,contenido);
                        p.setAutor(Autor);
                        publicaciones.add(p);
                        break;

                    default:
                        p = new PublicacionTexto(IdPubli,likes,dislikes,fecha,contenido);
                        p.setAutor(Autor);
                        publicaciones.add(p);
                        break;
                }

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return publicaciones;
    }

    @Override
    public void Borrar(){}
    @Override
    public List<IPublicacion> GetPublicacionesUsuario() {

        ResultSet rs=getPublicacionesUsuarioBd();
        // loop through the result set
           try {
               while (rs.next()){
                   //Variables auxiliares para que sea entendible todo esto
                   String aux=rs.getString(6);
                   String id=rs.getString(1);
                   int likes=rs.getInt(2);
                   int dislikes=rs.getInt(3);
                   String fecha=rs.getString(4);
                   String con=rs.getString(5);
                   IPublicacion p;

                   switch (aux){
                       case "texto":
                           p= new PublicacionTexto(id,likes,dislikes,fecha,con);
                           publicaciones.add(p);
                           break;

                       case "enlace":
                           p= new PublicacionEnlace(id,likes,dislikes,fecha,con);
                           publicaciones.add(p);
                           break;
                   }
               }
           }catch (SQLException e){
               System.err.println(e.getMessage());
           }

        accesobd.desconectar();
        return publicaciones;

    }

    //Metodo para obtener el resultSet de la BD
    private ResultSet getPublicacionesUsuarioBd(){
        accesobd=Conexion.getInstance();

        String url="select p_id,likes,dislikes,fecha,contenido,tipo " +
                "from publica inner join publicacion on publicacion.id=publica.p_id " +
                "where u_id="+"\""+this.alias+"\"";
        accesobd.conectar();
        ResultSet result= accesobd.ejecutarQuery(url);
        return result;
    }

    @Override
    public void publicar(PublicacionTexto texto) {
        accesobd=Conexion.getInstance();
        String query1="Insert into publicacion(id,likes,dislikes,contenido,tipo)\n" +
                "values("+"\""+texto.getId() +"\",\""+texto.getLikes() +"\",\""+texto.getDislikes()+"\",\""+texto.getContenido()+"\",\"texto\");";

        String query2= "INSERT INTO publica\n" +
                        "VALUES (\""+this.alias+"\",\""+texto.getId()+"\");";

        accesobd.conectar();
        accesobd.ejecutar(query1);
        accesobd.ejecutar(query2);
        accesobd.desconectar();
    }

    @Override
    public void publicar(PublicacionEnlace link) {
        accesobd=Conexion.getInstance();
        String query1="Insert into publicacion(id,likes,dislikes,contenido,tipo)\n" +
                "values("+"\""+link.getId() +"\",\""+link.getLikes() +"\",\""+link.getDislikes()+"\",\""+link.getContenido()+"\",\"enlace\");";

        String query2= "INSERT INTO publica\n" +
                "VALUES (\""+this.alias+"\",\""+link.getId()+"\");";

        accesobd.conectar();
        accesobd.ejecutar(query1);
        accesobd.ejecutar(query2);
        accesobd.desconectar();
    }

    @Override
    public void CambiarAlias(String alias) {
        System.out.println("LOCO FUNCIONA");
    }

    @Override
    public void RestaurarContrasena() {

    }

    @Override
    public void VerificarCredenciales(String credencial, String pssw) {

    }
}

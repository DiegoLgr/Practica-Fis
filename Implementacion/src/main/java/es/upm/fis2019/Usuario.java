package es.upm.fis2019;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Usuario implements IUsuario, IRecuperador, IPublicador {
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
    public List<IPublicacion> GetPublicacionesTimeline(String PrimeraFecha) {
        return null;
    }

    @Override
    public List<IPublicacion> GetPublicacionesUsuario(String PrimeraFecha) {

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
        String query="Insert into publicacion(id,likes,dislikes,contenido,tipo)\n" +
                "values("+"\""+texto.getId() +"\",\""+texto.getLikes() +"\",\""+texto.getDislikes()+"\",\""+texto.getContenido()+"\",\"texto\");";

        accesobd.conectar();
        accesobd.ejecutar(query);
        accesobd.desconectar();
    }

    @Override
    public void publicar(PublicacionEnlace link) {
        accesobd=Conexion.getInstance();
        String query="Insert into publicacion(id,likes,dislikes,contenido,tipo)\n" +
                "values("+"\""+link.getId() +"\",\""+link.getLikes() +"\",\""+link.getDislikes()+"\",\""+link.getContenido()+"\",\"enlace\");";

        accesobd.conectar();
        accesobd.ejecutar(query);
        accesobd.desconectar();
    }
}

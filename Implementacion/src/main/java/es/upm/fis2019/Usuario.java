package es.upm.fis2019;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Usuario implements IUsuario, IRecuperador {
    private String alias;
    private String correo;
    private String contraseña;
    private IEjecutador bd;
    private List<Publicacion> publicaciones;

    public Usuario(String alias, String correo, String contraseña) {
        this.alias = alias;
        this.correo = correo;
        this.contraseña = contraseña;
        publicaciones=null;
    }

    @Override
    public String getAlias() { return alias; }

    @Override
    public String getCorreo() { return correo; }

    @Override
    public List<Publicacion> GetPublicacionesTimeline(String PrimeraFecha) {
        return null;
    }

    @Override
    public List<Publicacion> GetPublicacionesUsuario(String PrimeraFecha) {

        ResultSet rs=getPublicacionesUsuarioBd();
        // loop through the result set
           try {
               while (rs.next()){
                   System.out.println(rs.getString(1));
               }
           }catch (SQLException e){
               System.err.println(e.getMessage());
           }

        return new ArrayList<Publicacion>();
        /*Publicacion[] publicaciones = new Publicacion[6];

        publicaciones[0] = new PublicacionTexto("1", 1, 1, "EN verdad Diego mola más");
        publicaciones[1] = new PublicacionEnlace("2", 4, 1, "www.Publicacion.enlace.es");
        publicaciones[2] = new PublicacionTexto("3", 100000, 1, "Por qué usar Git en vez de SVN");
        publicaciones[3] = new PublicacionTexto("4", 1, 1000, "Arriba Espania");
        publicaciones[5] = new PublicacionTexto("5", 100000, 1, "Colita");
        publicaciones[4] = new PublicacionTexto("3", 100000, 1, "vez de SVN");
        return publicaciones;
        */
    }

    private ResultSet getPublicacionesUsuarioBd(){
        Conexion c=Conexion.getInstance();

        String url="select p_id,likes,dislikes,fecha,contenido,tipo " +
                "from publica inner join publicacion on publicacion.id=publica.p_id " +
                "where u_id="+"\""+this.alias+"\"";
        c.conectar();
        ResultSet result= c.ejecutarQuery(url);
        c.desconectar();
        return result;
    }

    public IRecuperador asIrecuperador(){
        return this;
    }

    public static void main(String[] args) {

    }

}

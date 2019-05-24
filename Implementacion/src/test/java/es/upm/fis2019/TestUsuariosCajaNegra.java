package es.upm.fis2019;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

public class TestUsuariosCajaNegra {
    Usuario usr;
    private IEjecutador accesobd;
    Texto texto;
    PublicacionTexto publicacion;
    List<IPublicacion> publicaciones;

    private void limpiar() {
        String borrar_usuario = "DELETE FROM usuario WHERE  alias = 'franciscohc';";
        String borrar_publicacion = "DELETE FROM publicacion WHERE  id = 'España';";
        String borrar_publica = "DELETE FROM publica WHERE  u_id = 'franciscohc' AND p_id = 'España';";
        accesobd=Conexion.getInstance();
        accesobd.conectar();
        accesobd.ejecutar(borrar_usuario);
        accesobd.ejecutar(borrar_publicacion);
        accesobd.ejecutar(borrar_publica);
        accesobd.desconectar();
    }

    @Before
    public void setUp() throws Exception {
        accesobd=Conexion.getInstance();
        accesobd.conectar();
        String query1 = "insert into usuario (alias,correo,contraseña)\n" +
                "values(\"franciscohc\",\"franhc@gmail.com\",\"arribaespaña69\");";
        accesobd.ejecutar(query1);
        accesobd.desconectar();

        usr= new Usuario("franciscohc","franhc@gmail.com","arribaespaña69");
        texto = new Texto("España es el mejor país del mundo.");
        publicacion = new PublicacionTexto("España", 100, 0, texto);
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void getAlias() {
        accesobd.conectar();
        String query="select alias from usuario where alias = '"+usr.getAlias()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query);

        try {
            String alias=rs.getString(1);
            assertEquals(usr.getAlias(), alias);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        accesobd.desconectar();
    }

    @Test
    public void getCorreo() {
        accesobd.conectar();
        String query="select correo from usuario where alias = '"+usr.getAlias()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query);

        try {
            String correo=rs.getString(1);
            assertEquals(usr.getCorreo(), correo);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        accesobd.desconectar();
    }

    @Test
    public void getPublicacionesTimeline() {
    }

    @Test
    public void borrar() {
    }

    private void comparar(ResultSet rs, IPublicacion publicacion) {
        try {
            String aux=rs.getString(6);
            String id=rs.getString(1);
            int likes=rs.getInt(2);
            int dislikes=rs.getInt(3);
            String fecha=rs.getString(4);
            String contenido=rs.getString(5);

            assertEquals(id, publicacion.getId());
            assertEquals(likes, publicacion.getLikes());
            assertEquals(dislikes, publicacion.getDislikes());
            //assertEquals(fecha, publicacion.getFecha());
            assertEquals(contenido, publicacion.getContenido());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getPublicacionesUsuario() {
        String query="select *\n" +
                "from publicacion\n" +
                "where id in (select p_id\n" +
                "from publica pu, usuario u\n" +
                "where u.alias = pu.u_id\n" +
                "and u.alias = '"+usr.getAlias()+"')";
        accesobd.conectar();
        ResultSet rs = accesobd.ejecutarQuery(query);

        publicaciones = usr.GetPublicacionesUsuario("");

        for (IPublicacion p : publicaciones) { comparar(rs, p); }
    }

    @Test
    public void publicar() {
        usr.publicar(publicacion);
        accesobd.conectar();

        String query1="select * from publicacion where id = '"+publicacion.getId()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query1);
        comparar(rs, publicacion);

        accesobd.desconectar();
    }

    @Test
    public void publicar1() {
    }

    @Test
    public void cambiarAlias() {
    }

    @Test
    public void restaurarContrasena() {
    }

    @Test
    public void verificarCredenciales() {
    }

    public static void main(String[] args) throws Exception {
        TestUsuariosCajaNegra test = new TestUsuariosCajaNegra();
        test.limpiar();
        test.setUp();
        test.getAlias();
        test.getCorreo();
        test.publicar();
        test.getPublicacionesUsuario();
    }
}
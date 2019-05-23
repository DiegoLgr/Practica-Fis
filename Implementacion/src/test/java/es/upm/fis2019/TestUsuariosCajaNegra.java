package es.upm.fis2019;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

public class TestUsuariosCajaNegra {
    List<IPublicacion> publicaciones;
    Usuario usr;
    private IEjecutador accesobd;
    Texto texto;
    PublicacionTexto publicacion;

    @Before
    public void setUp() throws Exception {
        usr= new Usuario("franciscohc","franhc@gmail.com","arribaespaña69");
        texto = new Texto("España es el mejor país del mundo.");
        publicacion = new PublicacionTexto("España", 100, 0, texto);
        publicaciones = new ArrayList<IPublicacion>();

        accesobd=Conexion.getInstance();
        accesobd.conectar();
        String query1 = "insert into usuario (alias,correo,contraseña)\n" +
                //"values(\"franciscohc\",\"franhc@gmail.com\",\"arribaespaña69\");";
        //accesobd.ejecutar(query1);
        accesobd.desconectar();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void getAlias() {
        assertEquals("franciscohc", usr.getAlias());
    }

    @Test
    public void getCorreo() {
        assertEquals("franhc@gmail.com",usr.getCorreo());
    }

    @Test
    public void getPublicacionesTimeline() {
    }

    @Test
    public void borrar() {
    }

    @Test
    public void getPublicacionesUsuario() {
        String query1="select *\n" +
                "from publicacion\n" +
                "where id in (select p_id\n" +
                "from publica pu, usuario u\n" +
                "where u.alias = pu.u_id\n" +
                "and u.alias = '"+usr.getAlias()+"')";
        assertEquals(publicaciones, usr.GetPublicacionesUsuario("2019-05-12"));
    }

    @Test
    public void publicar() {
        usr.publicar(publicacion);
        accesobd.conectar();

        String query1="select * from publicacion where id = '"+publicacion.getId()+"';";
        ResultSet rs = accesobd.ejecutarQuery(query1);
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
        TestUsuariosCajaNegra test =new TestUsuariosCajaNegra();
        test.setUp();
        test.getAlias();
        test.getCorreo();
        test.publicar();
    }
}
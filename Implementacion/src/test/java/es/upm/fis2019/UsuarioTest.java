package es.upm.fis2019;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAlias() {
    }

    @Test
    public void getCorreo() {
    }

    @Test
    public void getPublicacionesTimeline() {
    }

    @Test
    public void getPublicacionesUsuario() {
        IComando com=new ComandoGetPublicacionesUsuario(new Usuario("Fran701","fgag","asgasg"));
        com.ejecutar();
    }

    @Test
    public void Publicar() {
        IComando com = new ComandoPublicar("Esta es du prueba","u","Enlace");
        com.ejecutar();
    }

    @Test
    public void cambiarAlias() {
        IComando com= new ComandoCambiarAlias("loco");
        com.ejecutar();
    }
}
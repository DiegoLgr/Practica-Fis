package es.upm.fis2019;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUsuariosCajaNegra {
    Usuario usr;
    @Before
    public void setUp() throws Exception {
       usr= new Usuario("a","aaa","aaaa");

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void getAlias() {

    }

    @Test
    public void getCorreo() {
        assertEquals("aaa",usr.getCorreo());
    }

    @Test
    public void getPublicacionesTimeline() {
    }

    @Test
    public void borrar() {
    }

    @Test
    public void getPublicacionesUsuario() {
    }

    @Test
    public void publicar() {
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



}
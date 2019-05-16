package es.upm.fis2019;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConexionTest {
    Conexion c;
    @Before
    public void setUp() throws Exception {
        c=Conexion.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void conectar() {
    }

    @Test
    public void desconectar() {
    }

    @Test
    public void ejecutar() {
    }

    @Test
    public void ejecutarQuery() {
        c.conectar();



        c.desconectar();
    }
}
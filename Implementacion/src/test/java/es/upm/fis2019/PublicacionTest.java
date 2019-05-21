package es.upm.fis2019;

import org.junit.Test;

import static org.junit.Assert.*;

public class PublicacionTest {

    @Test
    public void getComentarios() {
    }

    @Test
    public void likear() {
        ILikeable Publicacion = new PublicacionTexto("a",0,0,null);
        Publicacion.Likear(new Usuario("f","f","f"));

        //Y se muestran las publicaciones
        IComando com=new ComandoGetPublicacionesUsuario(new Usuario("a","fgag","asgasg"));
        com.ejecutar();
    }

    @Test
    public void dislikear() {
        ILikeable Publicacion = new PublicacionTexto("b",0,0,null);
        Publicacion.Dislikear(new Usuario("","",""));

        //Y se muestran las publicaciones
        IComando com=new ComandoGetPublicacionesUsuario(new Usuario("a","fgag","asgasg"));
        com.ejecutar();
    }

    @Test
    public void comentar() {
    }
}
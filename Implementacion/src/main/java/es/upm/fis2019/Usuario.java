package es.upm.fis2019;

import java.util.*;

public class Usuario implements IUsuario, IRecuperador {
    private String alias;
    private String correo;
    private String contraseña;
    private IEjecutador bd;

    public Usuario(String alias, String correo, String contraseña) {
        this.alias = alias;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    @Override
    public String getAlias() { return alias; }

    @Override
    public String getCorreo() { return correo; }

    @Override
    public Publicacion[] GetPublicacionesTimeline(Object PrimeraFecha) {
        return null;
    }

    @Override
    public Publicacion[] GetPublicacionesUsuario(Object PrimeraFecha) {
        Publicacion[] publicaciones = new Publicacion[6];

        publicaciones[0] = new PublicacionTexto("1", 1, 1, "EN verdad Diego mola más");
        publicaciones[1] = new PublicacionEnlace("2", 4, 1, "www.Publicacion.enlace.es");
        publicaciones[2] = new PublicacionTexto("3", 100000, 1, "Por qué usar Git en vez de SVN");
        publicaciones[3] = new PublicacionTexto("4", 1, 1000, "Arriba Espania");
        publicaciones[5] = new PublicacionTexto("5", 100000, 1, "Colita");
        publicaciones[4] = new PublicacionTexto("3", 100000, 1, "vez de SVN");
        return publicaciones;
    }

    //private ArrayList

    public IRecuperador asIrecuperador(){
        return this;
    }
}

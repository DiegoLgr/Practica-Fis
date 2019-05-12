package es.upm.fis2019;

public class Usuario implements IUsuario, IRecuperador {
    String id;
    String alias;
    String correo;
    String contraseña;

    public Usuario(String alias, String correo, String contraseña) {
        this.alias = alias;
        this.correo = correo;
        this.contraseña = contraseña;
        this.id = "1"; // Si se implementa, hay crear el usuario en la db y luego pedir el id que le da o algo asi.
    }

    @Override
    public String getId(){
        return this.id;
    }

    @Override
    public String getAlias() {
        return null;
    }

    @Override
    public String getCorreo() {
        return null;
    }

    @Override
    public Publicacion[] GetPublicacionesTimeline(Object PrimeraFecha) {
        return null;
    }

    @Override
    public Publicacion[] GetPublicacionesUsuario(Object PrimeraFecha) {
        PublicacionTexto[] publicaciones = new PublicacionTexto[6];

        publicaciones[0] = new PublicacionTexto("1", 1, 1, "Primera publicación");
        publicaciones[1] = new PublicacionTexto("2", 4, 1, "Como usar maven");
        publicaciones[2] = new PublicacionTexto("3", 100000, 1, "Por qué usar Git en vez de SVN");
        publicaciones[3] = new PublicacionTexto("4", 1, 1000, "hola Espania");
        publicaciones[5] = new PublicacionTexto("5", 100000, 1, "xgnfhmfhm");
        publicaciones[4] = new PublicacionTexto("3", 100000, 1, "vsfgmfmmvkjgyhjhj de SVN");
        return publicaciones;
    }

    public IRecuperador asIrecuperador(){
        return this;
    }
}

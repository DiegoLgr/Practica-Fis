package es.upm.fis2019;

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
    public String getAlias() { return null; }

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

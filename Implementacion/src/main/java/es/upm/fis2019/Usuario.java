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
        Publicacion[] publicaciones = new Publicacion[6];

        publicaciones[0] = new PublicacionTexto("1", 1, 1, "EN verdad Diego mola más");
        publicaciones[1] = new PublicacionEnlace("2", 4, 1, "www.Publicacion.enlace.es");
        publicaciones[2] = new PublicacionTexto("3", 100000, 1, "Por qué usar Git en vez de SVN");
        publicaciones[3] = new PublicacionTexto("4", 1, 1000, "Arriba Espania");
        publicaciones[5] = new PublicacionTexto("5", 100000, 1, "Colita");
        publicaciones[4] = new PublicacionTexto("3", 100000, 1, "vez de SVN");
        return publicaciones;
    }

    public IRecuperador asIrecuperador(){
        return this;
    }
}

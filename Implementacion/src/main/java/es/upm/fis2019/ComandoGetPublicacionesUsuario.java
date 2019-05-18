package es.upm.fis2019;
public class ComandoGetPublicacionesUsuario implements IComando {
    IRecuperador usuario;
    Publicacion[] publicaciones;

    public ComandoGetPublicacionesUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public void ejecutar(){
        IRecuperador recuperadorPublicaciones = usuario;
        this.publicaciones = recuperadorPublicaciones.GetPublicacionesUsuario("12/01/2019");
    }

    public Publicacion[] getPublicaciones(){
        return this.publicaciones;
    }
}

package es.upm.fis2019;
public class ComandoBorrarPublicacion implements IComando {
    IPublicacion publicacion;
    public ComandoBorrarPublicacion( IPublicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public void ejecutar() {
        IPublicacion publicacion = this.publicacion;
        Sesion.getInstance().getUsuario().borrarPublicacion(publicacion);

    }
}

package es.upm.fis2019;
public class ComandoBorrarPublicacion implements IComando {
    Iborrable publicacion;
    public ComandoBorrarPublicacion(Iborrable publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public void ejecutar() {
        Iborrable publicacion = this.publicacion;
        publicacion.Borrar();

    }
}

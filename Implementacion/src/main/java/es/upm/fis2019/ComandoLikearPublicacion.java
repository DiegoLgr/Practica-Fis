package es.upm.fis2019;
public class ComandoLikearPublicacion implements IComando {
    ILikeable publicacion;
    public ComandoLikearPublicacion(ILikeable publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public void ejecutar() {
        ILikeable likear = this.publicacion;
        likear.Likear(Sesion.getInstance().getUsuario());

    }
}

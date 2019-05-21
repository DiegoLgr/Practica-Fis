package es.upm.fis2019;
public class ComandoLikearPublicacion implements IComando {
    Publicacion publicacion;
    public ComandoLikearPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public void ejecutar() {
        ILikeable likear = this.publicacion;
        likear.Likear(Sesion.getInstance().getUsuario());

    }
}

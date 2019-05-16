package es.upm.fis2019;
public class ComandoLikearPublicacion implements IComando {
    Publicacion publicacion;
    public ComandoLikearPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public void ejecutar() {
        ILikeable likear = this.publicacion;
        likear.Likear(new Usuario("","",""));//Hay que recoger el usuario de la sesion

    }
}

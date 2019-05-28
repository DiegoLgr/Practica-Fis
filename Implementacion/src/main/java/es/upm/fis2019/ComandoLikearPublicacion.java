package es.upm.fis2019;
public class ComandoLikearPublicacion implements IComando {
    private int likes;
    private int dislikes;
    ILikeable publicacion;
    public ComandoLikearPublicacion(ILikeable publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public void ejecutar() {
        ILikeable likear = this.publicacion;
        likear.Likear(Sesion.getInstance().getUsuario(), this.likes, this.dislikes);
    }
    public void setLikesDislikes(int likes, int dislikes){
        this.likes = likes;
        this.dislikes = dislikes;
    }
}

package es.upm.fis2019;

public abstract class Publicacion implements IPublicacion,ILikeable {
    // TODO: Poner las fechas de alguna manera que funcionen
    String id;
    int likes;
    int dislikes;
    Contenido contenido;
    Object fecha;

    public Publicacion(String id, int likes, int dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
    }

}

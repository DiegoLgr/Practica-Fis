package es.upm.fis2019;

public abstract class Publicacion implements IPublicacion {
    // TODO: Poner las fechas de alguna manera que funcionen
    String id;
    int likes;
    int dislikes;
    Comentario[] comentarios;
    Contenido contenido;
    String fecha;

    public Publicacion(String id, int likes, int dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
    }
    @Override
    public String getId(){
        return id;
    }

    @Override
    public Comentario[] consultarComentarios() {
        return new Comentario[0];
    }

    @Override
    public int getLikes() {
        return likes;
    }

    @Override
    public int getDislikes() {
        return dislikes;
    }

    @Override
    public String getFecha() {
        return fecha;
    }
}

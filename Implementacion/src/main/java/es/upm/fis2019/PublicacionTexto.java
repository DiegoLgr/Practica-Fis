package es.upm.fis2019;

public class PublicacionTexto extends Publicacion{
    String contenido;
    public PublicacionTexto(String id, int likes, int dislikes, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getLikes() {
        return 0;
    }

    @Override
    public int getDislikes() {
        return 0;
    }

    @Override
    public <date> date getFecha() {
        return null;
    }

    public String getContenido() {
        String respresentaciónContenido = this.contenido + "    Likes: " +this.likes + "     Dislikes: " + this.dislikes;
        return respresentaciónContenido;
    }

    @Override
    public Comentario[] consultarComentarios() {
        return new Comentario[0];
    }
}

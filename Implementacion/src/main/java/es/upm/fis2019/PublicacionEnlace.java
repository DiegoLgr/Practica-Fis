package es.upm.fis2019;

public class PublicacionEnlace extends Publicacion {
    String contenido;
    public PublicacionEnlace(String id, int likes, int dislikes, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
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

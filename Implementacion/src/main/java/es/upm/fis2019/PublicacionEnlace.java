package es.upm.fis2019;

public class PublicacionEnlace extends Publicacion {
    private String contenido;
    public PublicacionEnlace(String id, int likes, int dislikes, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
    }

    public PublicacionEnlace(String id, int likes, int dislikes,String fecha, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
        super.setFecha(fecha);
    }


    public String getContenido() {
        //String respresentaciónContenido = this.contenido + "    Likes: " +this.likes + "     Dislikes: " + this.dislikes;
        return null;
    }

    @Override
    public Comentario[] consultarComentarios() {
        return new Comentario[0];
    }
}

package es.upm.fis2019;

public class PublicacionTexto extends Publicacion{
   private String contenido;

    //Constructor sin fecha para cuando se carga por primera vez
   public PublicacionTexto(String id, int likes, int dislikes, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
    }

    //Constructor con fecha para cuando se carga desde bd
    public PublicacionTexto(String id, int likes, int dislikes,String fecha, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
        super.setFecha(fecha);
    }


    public String getContenido() {
       // String respresentaciónContenido = this.contenido + "    Likes: " +this.likes + "     Dislikes: " + this.dislikes;
        return contenido;
   }

    @Override
    public Comentario[] consultarComentarios() {
        return new Comentario[0];
    }
}

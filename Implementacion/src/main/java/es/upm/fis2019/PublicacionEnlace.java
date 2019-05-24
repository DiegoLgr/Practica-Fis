package es.upm.fis2019;

public class PublicacionEnlace extends Publicacion {
    private String contenido;
    private IEnlace c;

    //Constructor sin fecha para cuando se carga por primera vez
    public PublicacionEnlace(String id, int likes, int dislikes, IEnlace contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido.getEnlace();
        this.c= contenido;
    }

    //Constructor con fecha para cuando se carga desde bd
    public PublicacionEnlace(String id, int likes, int dislikes,String fecha, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
        super.setFecha(fecha);
        this.c = new Enlace(contenido);
    }

    public String getContenido() {
        //String respresentaciónContenido = this.contenido + "    Likes: " +this.likes + "     Dislikes: " + this.dislikes;
        return contenido;
    }

}

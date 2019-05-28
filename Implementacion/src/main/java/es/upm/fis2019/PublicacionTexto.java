package es.upm.fis2019;

public class PublicacionTexto extends Publicacion{
   private String contenido;
   private ITexto c;
    //Constructor sin fecha para cuando se carga por primera vez
   public PublicacionTexto(String id, int likes, int dislikes, ITexto contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido.getTexto();
    }

    //Constructor con fecha para cuando se carga desde bd
    public PublicacionTexto(String id, int likes, int dislikes,String fecha, String contenido) {
        super(id, likes, dislikes);
        this.contenido = contenido;
        super.setFecha(fecha);
        this.c=new Texto(contenido);
    }


    public String getContenido() {
       // String respresentaciónContenido = this.contenido + "    Likes: " +this.likes + "     Dislikes: " + this.dislikes;
        return contenido;
   }
}

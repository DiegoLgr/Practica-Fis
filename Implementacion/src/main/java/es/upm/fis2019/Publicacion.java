package es.upm.fis2019;

public abstract class Publicacion implements IPublicacion,ILikeable,Iborrable {
    // TODO: Poner las fechas de alguna manera que funcionen
    private String id;
    private int likes;
    private int dislikes;
    private Comentario[] comentarios;
    private String fecha;

    public Publicacion(String id, int likes, int dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
        comentarios=null;
    }
    @Override
    public String getId(){
        return id;
    }

    //@Override
    public void AniadirComentario(Comentario comentario){
                                                                                         //Realizar el método
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

    @Override
    public void Likear(IUsuario user) {
        this.likes++;
        //Añadir el usuario a una lista de usuarios que han dado like
    }

    @Override
    public void Dislikear(IUsuario user) {
        this.dislikes++;
        //Añadir el usuario a una lista de usuarios que han dado dislike
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public void Borrar(){

    }

    public String toString(){
        String aux="id:"+this.id+" likes:"+this.likes+" dislikes:"+this.dislikes+" fecha:"+this.fecha+"\n";
        return aux;
    }
}

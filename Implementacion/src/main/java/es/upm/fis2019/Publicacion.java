package es.upm.fis2019;

import java.util.ArrayList;
import java.util.List;

public abstract class Publicacion implements IPublicacion,ILikeable,Iborrable {
    // TODO: Poner las fechas de alguna manera que funcionen
    private String id;
    private int likes;
    private int dislikes;
    private Comentario[] comentarios;
    private String fecha;
    private List<IUsuario> UsuariosLikes, UsuariosDislike;
    private IEjecutador accesobd;

    public Publicacion(String id, int likes, int dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
        comentarios=null;
        UsuariosLikes = new ArrayList<>();
        UsuariosDislike = new ArrayList<>();
        accesobd = Conexion.getInstance();
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
        UsuariosLikes.add(user); //Se aniade el usuario que ha dado like a una lista de usuarios que dan like

        String query = "UPDATE publicacion\n" +
                        "SET likes = 1 + (\n" +
                                "SELECT likes\n" +
                                "FROM publicacion\n"+
                                "WHERE id = \"" + this.id + "\"" +
                        ")\n" +
                        "WHERE id = \"" + this.id + "\";";
        accesobd.conectar();
        accesobd.ejecutar(query);
        accesobd.desconectar();
    }

    @Override
    public void Dislikear(IUsuario user) {
        this.dislikes++;
        UsuariosDislike.add(user);//Añadir el usuario a una lista de usuarios que han dado dislike

        String query = "UPDATE publicacion\n" +
                "SET dislikes = 1 + (\n" +
                    "SELECT dislikes\n" +
                    "FROM publicacion\n"+
                    "WHERE id = \"" + this.id + "\"" +
                ")\n" +
                "WHERE id = \"" + this.id + "\";";
        accesobd.conectar();
        accesobd.ejecutar(query);
        accesobd.desconectar();
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

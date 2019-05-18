package es.upm.fis2019;

import java.util.ArrayList;
import java.util.List;

public abstract class Publicacion implements IPublicacion,ILikeable,Iborrable,IComentable {
    private String id;
    private int likes;
    private int dislikes;
    private String fecha;
    private List<IComentario> comentarios;
    private IEjecutador accesobd;

    public Publicacion(String id, int likes, int dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
        this.fecha="";
        this.comentarios=new ArrayList<IComentario>();
        this.accesobd=Conexion.getInstance();
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public List<IComentario> getComentarios() {
        return comentarios;
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

    //Se necesita para evitar poner 2 constructores en publicacion padre
    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    @Override
    public void Borrar(){

    }

    @Override
    public void Comentar(String id,String txt){
        //Alias del usuario que hace el comentario
        String aux=Sesion.getInstance().getUsuario().getAlias();
        //Insercion en tablas comentario y comenta
        String tablaComentario="Insert into comentario(id,texto) values("+"\""+id+"\""+","+"\""+txt+"\""+");";
        String tablaComenta="insert into comenta values(\""+this.id+"\",\""+aux+"\",\""+id+"\");";

        accesobd.conectar();
        accesobd.ejecutar(tablaComentario);
        accesobd.ejecutar(tablaComenta);
        accesobd.desconectar();

        comentarios.add(new Comentario(id,txt));
    }


    public String toString(){
        String aux="id:"+this.id+" likes:"+this.likes+" dislikes:"+this.dislikes+" fecha:"+this.fecha+"\n";
        return aux;
    }

    public static void main(String[] args) {
        Publicacion a=new PublicacionEnlace("a",3,4,"asd");
        a.Comentar("c","askjvljylvgg");
       System.out.println(a.getComentarios().toString());
    }

}


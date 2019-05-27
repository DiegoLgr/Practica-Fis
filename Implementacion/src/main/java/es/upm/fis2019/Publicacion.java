package es.upm.fis2019;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Publicacion implements IPublicacion,ILikeable,IComentable {
    private String id;
    private int likes;
    private int dislikes;
    private String fecha;
    private List<IComentario> comentarios;
    private List<IUsuario> UsuariosLikes, UsuariosDislike;
    private IEjecutador accesobd;

    public Publicacion(String id, int likes, int dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
        UsuariosLikes = new ArrayList<>();
        UsuariosDislike = new ArrayList<>();
        this.fecha="";
        this.comentarios=new ArrayList<IComentario>();
        this.accesobd=Conexion.getInstance();
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
    public List<IComentario> getComentarios() {
        String query = "SELECT c_id, texto, fecha, respuesta, u_id\n" +
                "FROM comenta INNER JOIN comentario ON comentario.id = comenta.c_id\n" +
                "WHERE p_id = \""+this.id+"\";";

        accesobd.conectar();
        ResultSet a = accesobd.ejecutarQuery(query);
        ObtenerListaDeComentarios(a); //Aquí trabajamos con los datos obtenidos
        accesobd.desconectar();
        return comentarios;
    }

    private void ObtenerListaDeComentarios(ResultSet rs){
        try {
            while (rs.next()){


                String idComentario = rs.getString(1);
                String texto = rs.getString(2);
                String fecha = rs.getString(3);
                String respuesta = rs.getString(4);
                String autor = rs.getString(5);

                if(!ExisteComentarioEnLista(idComentario))
                    comentarios.add(new Comentario(idComentario,texto,fecha,respuesta,autor));
/*
                if(!this.comentarios.contains(new Comentario(idComentario,texto,fecha,respuesta,autor))){
                    comentarios.add(new Comentario(idComentario,texto,fecha,respuesta,autor));
                }
*/
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private boolean ExisteComentarioEnLista(String id){
        boolean existe = false;
        for(IComentario comentario: this.comentarios){
            if(comentario.getId() == id) existe = true;
        }
        return existe;
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
    public void Dislikear(IUsuario user, int likes, int dislikes) {
      this.Likear(user, likes, dislikes);
    }

    @Override
    public void Likear(IUsuario user, int likes, int dislikes) {
        this.dislikes = dislikes;
        this.likes = likes;
        UsuariosDislike.add(user);//Añadir el usuario a una lista de usuarios que han dado dislike

        String queryLikes = "UPDATE publicacion\n" +
                "SET likes = " + this.likes + "\n" +
                "WHERE id = \"" + this.id + "\";";

        String queryDislikes = "UPDATE publicacion\n" +
                "SET dislikes = " + this.dislikes +"\n" +
                "WHERE id = \"" + this.id + "\";";
        accesobd.conectar();
        accesobd.ejecutar(queryLikes);
        accesobd.ejecutar(queryDislikes);
        accesobd.desconectar();
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

        comentarios.add(new Comentario(id,txt,Sesion.getInstance().getUsuario().getAlias()));
    }


    public String toString(){
        String aux="id:"+this.id+" likes:"+this.likes+" dislikes:"+this.dislikes+" fecha:"+this.fecha+"\n";
        return aux;
    }



}


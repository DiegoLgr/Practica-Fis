package es.upm.fis2019;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Publicacion implements IPublicacion,ILikeable,Iborrable,IComentable {
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

                if(!this.comentarios.contains(new Comentario(idComentario,texto,fecha,respuesta,autor))){
                    comentarios.add(new Comentario(idComentario,texto,fecha,respuesta,autor));
                }

            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
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

    }

}


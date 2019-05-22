package es.upm.fis2019;

public class Comentario implements IComentario{
    private String id ;
    private String texto;
    private String fecha;
    private String respuesta;
    private  String Autor;

    //Constructor para crear los comentarios
    public Comentario(String id, String texto){

        this.id = id ;
        this.texto = texto;
        this.fecha ="";
        this.respuesta = "";
    }
    //Constructor para cargarlos de BD
    public Comentario( String id,String texto,String fecha,String respuesta, String Autor){
        this.id = id ;
        this.texto = texto;
        this.fecha =fecha;
        this.respuesta = respuesta;
        this.Autor = Autor;
    }

    @Override
    public String getId() {
        return id;
    }
    //Vox

    @Override
    public String getTexto() {
        return texto;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public String getRespuesta() {
        return respuesta;
    }

    @Override
    public String toString(){
        String aux="id:"+this.id+" texto:"+this.texto+" fecha:"+this.fecha+" respuesta:"+this.respuesta;

        return aux;
    }

}

package es.upm.fis2019;

public class Comentario implements IComentario, IRespondible{
    private String id ;
    private String texto;
    private String fecha;
    private String respuesta;
    private  String Autor;

    //Constructor para crear los comentarios
    public Comentario(String id, String texto,String autor){

        this.id = id ;
        this.texto = texto;
        this.fecha ="";
        this.respuesta = "";
        this.Autor=autor;
    }
    //Constructor para cargarlos de BD, meter el alias del usuario que lo crea como autor
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

    //Es basicamente un setRespuesta.
    @Override
    public void Responder(String texto) {
            this.respuesta=texto;
    }

    @Override
    public String toString(){
        String aux="id:"+this.id+" texto:"+this.texto+" fecha:"+this.fecha+" respuesta:"+this.respuesta + " autor:" +this.Autor;

        return aux;
    }


}

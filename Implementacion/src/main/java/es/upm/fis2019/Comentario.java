package es.upm.fis2019;

public class Comentario implements IComentario {
    String id;
    String texto;
    String fecha;
    String respuesta;

    public Comentario(String id, String texto, String fecha, String respuesta){
        this.id = id;
        this.texto = texto;
        this.fecha = fecha;
        this.respuesta = respuesta;
    }

    @Override
    public String getId() {
        return id;
    }

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
}

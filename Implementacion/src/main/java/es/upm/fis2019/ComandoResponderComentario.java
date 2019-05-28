package es.upm.fis2019;
public class ComandoResponderComentario implements IComando {

    IRespondible cometario;
    String respuesta;

    public ComandoResponderComentario (IRespondible comentario,String respuesta){
        this.cometario=comentario;
        this.respuesta=respuesta;
    }
    @Override
    public void ejecutar() {
        IRespondible coment = this.cometario;
        coment.Responder(respuesta);
    }
}

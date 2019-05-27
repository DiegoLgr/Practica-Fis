package es.upm.fis2019;
public class ControladorComentario implements IResponde {
	public void responderComentario(String respuesta, IRespondible coment){
		IComando respondercomentario = new ComandoResponderComentario(coment,respuesta);
		respondercomentario.ejecutar();

	};
}

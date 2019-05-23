package es.upm.fis2019;
public class ControladorPublicaciones implements IComenta, IBorraPublicacion, ILikea {

	public Boolean comentarPublicacion(Publicacion publicacion, String texto){
		IComando comandoComentarPubli = new ComandoComentarPublicacion(publicacion, texto);
		comandoComentarPubli.ejecutar();
		return true;
	}
	public Boolean borrarPublicacion(Publicacion publicacion){

		ComandoBorrarPublicacion borrarPublicacion = new ComandoBorrarPublicacion(publicacion);

		borrarPublicacion.ejecutar();

		return true;
	};
	public Boolean likear(Publicacion publicacion){

		IComando comandoLikearPublicacion = new ComandoLikearPublicacion(publicacion);
		comandoLikearPublicacion.ejecutar();
		return true;
	};
	public Boolean dislikear(Publicacion publicacion){
		IComando dislikear = new ComandoDislikearPublicacion(publicacion);
		dislikear.ejecutar();
		return true;
	};

}

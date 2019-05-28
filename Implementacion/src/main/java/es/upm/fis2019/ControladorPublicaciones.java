package es.upm.fis2019;
public class ControladorPublicaciones implements IComenta, IBorraPublicacion, ILikea {

	public Boolean comentarPublicacion(Publicacion publicacion, String texto){
		IComando comandoComentarPubli = new ComandoComentarPublicacion(publicacion, texto);
		comandoComentarPubli.ejecutar();
		return true;
	}
	public Boolean borrarPublicacion(IPublicacion publicacion){

		ComandoBorrarPublicacion borrarPublicacion = new ComandoBorrarPublicacion(publicacion);

		borrarPublicacion.ejecutar();

		return true;
	};
	public Boolean likear(Publicacion publicacion, int likes, int dislikes){
		IComando comandoLikearPublicacion = new ComandoLikearPublicacion(publicacion);
		((ComandoLikearPublicacion) comandoLikearPublicacion).setLikesDislikes(likes, dislikes);
		comandoLikearPublicacion.ejecutar();
		return true;
	};
	public Boolean dislikear(Publicacion publicacion, int likes, int dislikes){
		IComando dislikear = new ComandoDislikearPublicacion(publicacion);
		((ComandoDislikearPublicacion) dislikear).setLikesDislikes(likes, dislikes);
		dislikear.ejecutar();
		return true;
	};

}

package es.upm.fis2019;
public class ControladorPublicaciones implements IComenta, IBorraPublicacion, ILikea {
	public Boolean comentarPublicacion(Publicacion publicacion, String texto){
		return true;
	};
	public Boolean borrarPublicacion(Publicacion publicacion){
		return true;
	};
	public Boolean likear(Publicacion publicacion){
		return true;
	};
	public Boolean dislikear(Publicacion publicacion){
		ComandoDislikearPublicacion dislikear = new ComandoDislikearPublicacion(publicacion);
		dislikear.ejecutar();
		return true;
	};

}

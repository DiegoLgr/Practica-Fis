package es.upm.fis2019;
public class ControladorUsuario implements IAutentica, IEliminarUsuario, IPublica, IPidePublicacion {
    Sesion sesion;
    private int idpublicacion = 0;
	public ControladorUsuario(Sesion sesion){
		this.sesion = sesion;
	}

	public Boolean verificar(String credencial, String passw){
		return true;
	};
	public Boolean cambiarAlias(String nuevoAlias){
		return true;
	};
	public Boolean eliminarUsuario(){
		return true;
	};
	public Boolean publicar(String Contenido, String Tipo){
		idpublicacion++;
		ComandoPublicar comandoPublicar = new ComandoPublicar(Contenido, Integer.toString(idpublicacion), Tipo);
		comandoPublicar.ejecutar();
		return true;
	}
	public Publicacion[] getPublicacionesTimeline(){
	    return null;
	};

	public Publicacion[] getPublicacionesPropias(){
		ComandoGetPublicacionesUsuario comandoGetPublicacionesUsuario = new ComandoGetPublicacionesUsuario(this.sesion.getUsuario());
		comandoGetPublicacionesUsuario.ejecutar();
		return comandoGetPublicacionesUsuario.getPublicaciones();
	};

	public Publicacion[] getPublicacionesUsuario(){
	    return null;
	};
}

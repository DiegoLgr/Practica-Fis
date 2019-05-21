package es.upm.fis2019;

import java.util.List;

public class ControladorUsuario implements IAutentica, IEliminarUsuario, IPublica, IPidePublicacion {
    private Sesion sesion;
    private int idpublicacion = 0;

	public ControladorUsuario(Sesion sesion){
		this.sesion = Sesion.getInstance();
	}

	public Boolean verificar(String credencial, String passw){
		return true;
	}
	public Boolean cambiarAlias(String nuevoAlias){
		return true;
	}
	public Boolean eliminarUsuario(){
		return true;
	}
	public Boolean publicar(String Contenido, String Tipo){
		idpublicacion++;
		ComandoPublicar comandoPublicar = new ComandoPublicar(Contenido, Integer.toString(idpublicacion), Tipo);
		comandoPublicar.ejecutar();
		return true;
	}
	public List<IPublicacion> getPublicacionesTimeline(){
	    return null;
	}

	public List<IPublicacion> getPublicacionesPropias(){
		ComandoGetPublicacionesUsuario comandoGetPublicacionesUsuario =
				new ComandoGetPublicacionesUsuario(sesion.getUsuario());
		comandoGetPublicacionesUsuario.ejecutar();
		return comandoGetPublicacionesUsuario.getPublicaciones();
	}

	public List<Publicacion> getPublicacionesUsuario(){
	    return null;
	}
}

package es.upm.fis2019;

import java.util.List;

public class ControladorUsuario implements IAutentica, IEliminarUsuario, IPublica, IPidePublicacion {
    Sesion sesion;
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
	public Boolean publicar(Object Contenido){
		return null;
	};
	public List<Publicacion> getPublicacionesTimeline(){
	    return null;
	};

	public List<Publicacion> getPublicacionesPropias(){
		ComandoGetPublicacionesUsuario comandoGetPublicacionesUsuario = new ComandoGetPublicacionesUsuario(this.sesion.getUsuario());
		comandoGetPublicacionesUsuario.ejecutar();
		return comandoGetPublicacionesUsuario.getPublicaciones();
	};

	public List<Publicacion> getPublicacionesUsuario(){
	    return null;
	};
}

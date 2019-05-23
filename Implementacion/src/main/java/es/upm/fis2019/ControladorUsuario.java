package es.upm.fis2019;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ControladorUsuario implements IAutentica, IEliminarUsuario, IPublica, IPidePublicacion {
    private Sesion sesion;

	public ControladorUsuario(Sesion sesion){
		this.sesion = Sesion.getInstance();
	}

	public Boolean verificar(String credencial, String passw){
		return true;
	}
	public Boolean cambiarAlias(String nuevoAlias){
		return true;
	}
	public void eliminarUsuario(Usuario usuario){

		ComandoBorrarUsuario borraru= new ComandoBorrarUsuario(usuario);

		borraru.ejecutar();
	}
	public Boolean publicar(String Contenido, String Tipo){

		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();
		String todayAsString = df.format(today);

		ComandoPublicar comandoPublicar = new ComandoPublicar(Contenido, todayAsString, Tipo);
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

package es.upm.fis2019;

import java.util.List;

public interface IRecuperador {
	public List<Publicacion> GetPublicacionesTimeline(String PrimeraFecha);
	public List<Publicacion> GetPublicacionesUsuario(String PrimeraFecha);
}

package es.upm.fis2019;

import java.util.List;

public interface IRecuperador {
	public List<IPublicacion> GetPublicacionesTimeline(String PrimeraFecha);
	public List<IPublicacion> GetPublicacionesUsuario(String PrimeraFecha);
}

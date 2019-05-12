package es.upm.fis2019;
public interface IRecuperador {
	public Publicacion[] GetPublicacionesTimeline(Object PrimeraFecha);
	public Publicacion[] GetPublicacionesUsuario(Object PrimeraFecha);
}

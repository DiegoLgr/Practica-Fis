package es.upm.fis2019;

import java.util.List;

public interface IPidePublicacion {
	public List<IPublicacion> getPublicacionesTimeline();
	public List<IPublicacion> getPublicacionesPropias();
	public List<Publicacion> getPublicacionesUsuario();
}

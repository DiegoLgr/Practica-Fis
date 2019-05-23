package es.upm.fis2019;

import java.util.List;

public interface IRecuperador {
	 List<IPublicacion> GetPublicacionesTimeline();
	 List<IPublicacion> GetPublicacionesUsuario();
}

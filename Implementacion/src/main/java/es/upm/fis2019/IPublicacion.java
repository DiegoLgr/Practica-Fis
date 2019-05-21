package es.upm.fis2019;

import java.util.List;

public interface IPublicacion {
	public String getId();
	public int getLikes();
	public int getDislikes();
	public String getFecha();
	public List<IComentario> getComentarios();
	public String getContenido();
}

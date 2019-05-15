package es.upm.fis2019;
public interface IPublicacion {
	public String getId();
	public int getLikes();
	public int getDislikes();
	public String getFecha();
	public Comentario[] consultarComentarios();
	public String getContenido();
}

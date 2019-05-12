package es.upm.fis2019;
public interface IPublicacion {
	public int getId();
	public int getLikes();
	public int getDislikes();
	public <date> date getFecha();
	public Comentario[] consultarComentarios();
	public String getContenido();
}

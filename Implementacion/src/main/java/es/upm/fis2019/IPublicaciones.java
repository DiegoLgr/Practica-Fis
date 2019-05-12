package es.upm.fis2019;
public interface IPublicaciones {
	public void publicarTexto(Usuario autor, String texto);
	public void publicarReferencia(Usuario autor, int idPublicacion);
	public void publicarEnlace(Usuario autor, String url);
	public void borrarPublicacion(int id);
	public void likear(Usuario usuario, int idPublicacion);
	public void dislikear(Usuario usuario, int idPublicacion);
}

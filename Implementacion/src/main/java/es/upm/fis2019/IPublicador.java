package es.upm.fis2019;
public interface IPublicador {
	public void publicar(PublicacionTexto texto);
	public void publicar(PublicacionEnlace link);
	public void publicar(PublicacionReferenciable ref);
}

package es.upm.fis2019;
public interface IVistaUsuario {
	public void verificarCredenciales();
	public void resetearContrasena();
	public void cambiarAlias();
	public void registrarUsuario();
	public void getPublicacionesTimeline();
	public void getPublicacionesUsuario();
	public void comentarPublicacion();
	public void responderPublicacion();
	public void likearPublicacion();
	public void dislikearPublicacion();
	public void borrarPublicacion();
	public void publicar();
	public void buscarUsuario();
	public void borrarUsuario();
}

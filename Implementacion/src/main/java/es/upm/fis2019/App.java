package es.upm.fis2019;

public class App {
	public static void main(String[] args) {
		Sesion sesion = new Sesion();
		sesion.setUsuario(new Usuario("usuarioPrueba", "prueba@upm.com", "123")); // Esto hace lo que debieria hacer el login.

		ControladorGestorUsuarios controladorGestorUsuarios = new ControladorGestorUsuarios();
		ControladorUsuario controladorUsuario = new ControladorUsuario(sesion);
		ControladorComentario controladorComentario = new ControladorComentario();
		ControladorPublicaciones controladorPublicaciones = new ControladorPublicaciones();

		ManagerGui gui = new ManagerGui(controladorGestorUsuarios, controladorUsuario);
		gui.run();
	}
}

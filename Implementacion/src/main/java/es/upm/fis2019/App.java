package es.upm.fis2019;

import es.upm.fis2019.GUI.ManagerGUI;

public class App {
	public static void main(String[] args) {
		lanzarApp();
		//runTests();
	}
	private static void lanzarApp(){

		ControladorGestorUsuarios controladorGestorUsuarios = new ControladorGestorUsuarios();
		ControladorComentario controladorComentario = new ControladorComentario();
		ControladorPublicaciones controladorPublicaciones = new ControladorPublicaciones();

		ManagerGUI gui = new ManagerGUI(controladorGestorUsuarios);
		gui.run();
	}
	private static void runTests(){
		System.out.println("~~~ Publicaciones ~~~");
		TestPublicacion.testGetLikes();
		TestPublicacion.testGetDislikes();


		System.out.println("~~~ Comentario ~~~");
	/*
		TestComentario.testGetFecha();
		TestComentario.testGetId();
		TestComentario.testGetText();
		TestComentario.testGetRespuesta();
	 */
		System.out.println("~~~ ControladorUsuario ~~~");
		//TestControladorUsuario.testGetPublicacionesPropias();
		//TestControladorUsuario.TestPublicar();
	}
}

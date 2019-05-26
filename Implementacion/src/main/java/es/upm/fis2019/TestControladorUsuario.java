package es.upm.fis2019;
import java.util.List;

public class TestControladorUsuario {
    public static void testGetPublicacionesPropias() {
        Sesion sesion = new Sesion(new Usuario("Siorata", "", "Siorata"));
        ControladorUsuario controladorUsuario = new ControladorUsuario(sesion);
        List<IPublicacion> publicaciones = controladorUsuario.getPublicacionesPropias();
        for (IPublicacion i : publicaciones) {
            System.out.println(i.getContenido());
        }
    }

    public static void TestPublicar() {
        Sesion sesion = new Sesion(new Usuario("Siorata", "", "Siorata"));
        sesion.setUsuario(new Usuario("Siorata", "Prueba@usuario.com", "Siorata"));
        ControladorUsuario controladorUsuario = new ControladorUsuario(sesion);
        controladorUsuario.publicar("nada", "Texto");
    }
}



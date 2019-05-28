package es.upm.fis2019;
import java.util.List;

public class TestControladorUsuario {
    public static void testGetPublicacionesPropias() {
        Sesion sesion = new Sesion();
        sesion.setUsuario(new Usuario("Siorata", "", "Siorata"));
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        List<IPublicacion> publicaciones = controladorUsuario.getPublicacionesPropias();
        for (IPublicacion i : publicaciones) {
            System.out.println(i.getContenido());
        }
    }

    public static void TestPublicar() {
        Sesion sesion = new Sesion();
        sesion.setUsuario(new Usuario("Siorata", "", "Siorata"));
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.publicar("nada", "Texto");
    }
}



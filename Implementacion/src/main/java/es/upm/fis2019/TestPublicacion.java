package es.upm.fis2019;

public class TestPublicacion {
    public static void testGetLikes (){
        Publicacion publicacion = new PublicacionTexto("1", 1, 2, "Publicacion de prueba");
        IPublicacion publicacionEnVista = publicacion;
        System.out.println("Test get Likes should be 1: " + publicacionEnVista.getLikes());

        ControladorPublicaciones controladorPublicaciones = new ControladorPublicaciones();
        //Dar like
        controladorPublicaciones.likear(publicacion);
        System.out.println("Like +1 , test get Likes should be 2: " + publicacionEnVista.getLikes());




    }
    public static void testGetDislikes (){
        Publicacion publicacion = new PublicacionTexto("1", 1, 2, "Publicacion de prueba");
        IPublicacion publicacionEnVista = publicacion;
        System.out.println("Dislikes in publicaciones should be 2: " + publicacionEnVista.getDislikes());
    }
}

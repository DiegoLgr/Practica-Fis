package es.upm.fis2019;

public class TestPublicacion {
    public static void testGetLikes (){
        Publicacion publicacion = new PublicacionTexto("1", 1, 2, new Texto("Publicacion de prueba"));
        IPublicacion publicacionEnVista = publicacion;
        System.out.println("Test get Likes should be 1: " + publicacionEnVista.getLikes());

        ControladorPublicaciones controladorPublicaciones = new ControladorPublicaciones();
        //Dar like
        controladorPublicaciones.likear(publicacion, 1, 1);
        System.out.println("Like +1 , test get Likes should be 2: " + publicacionEnVista.getLikes());




    }
    public static void testGetDislikes (){
        Publicacion publicacion = new PublicacionTexto("1", 1, 2, new Texto("Publicacion de prueba"));
        IPublicacion publicacionEnVista = publicacion;
        System.out.println("Dislikes in publicaciones should be 2: " + publicacionEnVista.getDislikes());
    }
}

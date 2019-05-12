package es.upm.fis2019;
public class GestorPublicaciones  implements IRecuperador, IEjecutador, IPublicador {

    @Override
    public void ejecutar(String peticion) {

    }

    @Override
    public Boolean conectar() {
        return null;
    }

    @Override
    public void publicar(PublicacionTexto texto) {

    }

    @Override
    public void publicar(PublicacionEnlace link) {

    }

    @Override
    public void publicar(PublicacionReferenciable ref) {

    }

    @Override
    public Publicacion[] GetPublicacionesTimeline(Object PrimeraFecha) {
        return new Publicacion[0];
    }

    @Override
    public Publicacion[] GetPublicacionesUsuario(Object PrimeraFecha) {
        return new Publicacion[0];
    }
}

package es.upm.fis2019;
public class ComandoPublicar implements IComando {
    private String Contenido;
    private String ID, Tipo;

    public ComandoPublicar(String contenido, String ID, String Tipo) {
        this.Contenido = contenido;
        this.ID = ID;
        this.Tipo = Tipo;

    }

    @Override
    public void ejecutar() {
        IPublicador publicacion = Sesion.getInstance().getUsuario();
        switch (Tipo){
            case "Texto": publicacion.publicar(new PublicacionTexto(ID,0,0, new Texto(Contenido))); break;
            case "Enlace": publicacion.publicar(new PublicacionEnlace(ID,0,0, new Enlace(Contenido))); break;
            //case "Referencia": publicacion.publicar(new PublicacionReferencia()); break;
            default:
                System.out.println("La cadena esta mal");
        }

    }
}

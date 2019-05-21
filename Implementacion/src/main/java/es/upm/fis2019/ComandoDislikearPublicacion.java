package es.upm.fis2019;
public class ComandoDislikearPublicacion implements IComando {

    Publicacion publicacion;
    ComandoDislikearPublicacion(Publicacion publicacion){this.publicacion = publicacion;}
    @Override
    public void ejecutar() {

        ILikeable dislikear = this.publicacion;
        dislikear.Dislikear(Sesion.getInstance().getUsuario());

    }
}

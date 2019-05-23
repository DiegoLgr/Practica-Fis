package es.upm.fis2019;
public class ComandoDislikearPublicacion implements IComando {

    ILikeable publicacion;
    ComandoDislikearPublicacion(ILikeable publicacion){this.publicacion = publicacion;}
    @Override
    public void ejecutar() {

        ILikeable dislikear = this.publicacion;
        dislikear.Dislikear(Sesion.getInstance().getUsuario());

    }
}

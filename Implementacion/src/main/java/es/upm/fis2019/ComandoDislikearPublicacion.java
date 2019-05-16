package es.upm.fis2019;
public class ComandoDislikearPublicacion implements IComando {

     int dislikes;

    Publicacion publicacion;
    ComandoDislikearPublicacion(Publicacion publicacion){this.publicacion = publicacion;}

    public void ejecutar() {

        ILikeable dislikear = this.publicacion;
        dislikear.Dislikear(new Usuario("aa","aa","aa"));//hay que poner el singletone

    }
}

package es.upm.fis2019;

import java.util.List;

public class ComandoGetPublicacionesUsuario implements IComando {
    private IRecuperador usuario;
    private List<IPublicacion> publicaciones;

    public ComandoGetPublicacionesUsuario(IRecuperador usuario){
        this.usuario = usuario;
    }
    public void ejecutar(){
        IRecuperador recuperadorPublicaciones = usuario;
        this.publicaciones = recuperadorPublicaciones.GetPublicacionesUsuario("12/01/2019");
    }

    public List<IPublicacion> getPublicaciones(){
        return this.publicaciones;
    }
}

package es.upm.fis2019;

import java.util.ArrayList;
import java.util.List;

public class ComandoGetPublicacionesTimeline implements IComando {
    private IRecuperador usuario;
    private List<IPublicacion> publicaciones;

    public ComandoGetPublicacionesTimeline(IRecuperador usuario) {
        this.usuario = usuario;
        this.publicaciones = new ArrayList<>();
    }

    @Override
    public void ejecutar() {
        this.publicaciones = this.usuario.GetPublicacionesTimeline();
    }

    public List<IPublicacion> getTimeline (){
        return this.publicaciones;
    }
}

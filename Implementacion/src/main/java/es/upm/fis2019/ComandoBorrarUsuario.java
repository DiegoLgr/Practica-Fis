package es.upm.fis2019;
public class ComandoBorrarUsuario implements IComando {
    Iborrable usuario;
    public ComandoBorrarUsuario(Iborrable usuario) {
        this.usuario = usuario;
    }

    @Override
    public void ejecutar() {
        Iborrable publicacion = this.usuario;
        publicacion.Borrar();

    }
}

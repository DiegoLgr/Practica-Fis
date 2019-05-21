package es.upm.fis2019;
public class ComandoBuscarUsuario implements IComando {
    IUsuario usuario;
    String id;
    public ComandoBuscarUsuario(String id ) {
         this.id=id;

    }

    @Override
    public void ejecutar() {
        IBuscador buscar = new GestorUsuarios();

       this.usuario= buscar.Buscar(id);

    }
    public IUsuario getUsuario(){

        return this.usuario;
    }
}

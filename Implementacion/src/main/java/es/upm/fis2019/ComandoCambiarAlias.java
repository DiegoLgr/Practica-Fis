package es.upm.fis2019;
public class ComandoCambiarAlias implements IComando {

    String alias;

    public ComandoCambiarAlias(String newalias){
        this.alias=newalias;
    }
    @Override
    public void ejecutar() {

            Sesion.getInstance().getUsuario().CambiarAlias(this.alias);


    }
}

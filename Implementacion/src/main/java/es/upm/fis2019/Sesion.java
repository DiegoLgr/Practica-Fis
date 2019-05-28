package es.upm.fis2019;

public class Sesion {
    private Usuario usuario;
    private static Sesion sesion;

    public Sesion(){
        sesion=this;
    }

    public static Sesion getInstance(){
        return sesion;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuario(){
        return this.usuario;
    }
}

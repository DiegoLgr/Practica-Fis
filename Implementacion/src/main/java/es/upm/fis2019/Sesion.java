package es.upm.fis2019;

public class Sesion {
    private IUsuario usuario;
    private static Sesion sesion;

    public Sesion(IUsuario user){
        usuario = user;
    }

    public static Sesion getInstance(){
        return sesion;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public IUsuario getUsuario(){
        return this.usuario;
    }
}

package es.upm.fis2019;

public class Sesion {
    private Usuario usuario;
    private static Sesion sesion;

    public Sesion(Usuario user){
        usuario = user;
    }

    public static Sesion getInstance(){
        if (sesion==null)
            sesion=new Sesion(new Usuario("a","a","a"));
        return sesion;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuario(){
        return this.usuario;
    }
}

package es.upm.fis2019;

public class Sesion {
    private IUsuario usuario;
    private static Sesion sesion;
    public Sesion(){
        usuario= new Usuario("a" ,"a","a");
    }

    public Sesion(IUsuario user){
        usuario = user;
    }

    public Sesion getInstance(IUsuario usuario){
        if(sesion==null)
            sesion= new Sesion(usuario);
        return this;
    }




    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public IUsuario getUsuario(){
        return this.usuario;
    }
}

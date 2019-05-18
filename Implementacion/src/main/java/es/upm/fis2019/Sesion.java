package es.upm.fis2019;

public class Sesion {
    private IUsuario usuario;
    private static Sesion sesion;
    private Sesion(){
        usuario= new Usuario("a" ,"a","a");
    }
    public static Sesion getInstance(IUsuario usuario){

        if(sesion==null)
            sesion= new Sesion(usuario);
    }




    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuario(){
        return this.usuario;
    }
}

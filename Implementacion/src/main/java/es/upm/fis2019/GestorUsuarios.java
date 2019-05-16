package es.upm.fis2019;

public class GestorUsuarios implements ICreador,IBuscador{
   private IEjecutador accesobd;

   public GestorUsuarios (){
       accesobd=Conexion.getInstance();
   }

    @Override
    public void Crear(String alias, String correo, String pssw){
        String query="Insert into usuario values("+alias +","+correo +","+pssw+");"  ;

        accesobd.conectar();
        accesobd.ejecutar(query);
        accesobd.desconectar();
    }

    @Override //No hay que que implementarlo
    public IUsuario Buscar(String alias) {
        return null;
    }





    public static void main(String[] args) {
        GestorUsuarios g=new GestorUsuarios();
        g.Crear("ca","ca","ca");
    }
}

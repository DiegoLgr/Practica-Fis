package es.upm.fis2019;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GestorUsuarios implements ICreador,IBuscador{
   private IEjecutador accesobd;
   private List<String> atributos;

   public GestorUsuarios (){
       accesobd=Conexion.getInstance();
   }

    @Override
    public void Crear(String alias, String correo, String pssw){
        String query="Insert into usuario values('"+alias +"','"+correo +"','"+pssw+"');"  ;

        accesobd.conectar();
        accesobd.ejecutar(query);
        accesobd.desconectar();
    }

    @Override
    public IUsuario Buscar(String alias) {
        String query = "select alias, correo, contraseña from usuario where alias='" + alias + "';";

        accesobd.conectar();
        ResultSet rs= accesobd.ejecutarQuery(query);

        Usuario usuario = null;
        try {
            String correo = rs.getString(2);
            String contraseña = rs.getString(3);

            usuario = new Usuario(alias, correo, contraseña);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        
        accesobd.desconectar();

        return usuario;
    }

    public static void main(String[] args) {
        GestorUsuarios g=new GestorUsuarios();
        g.Crear("asdf","ca","ca");
        IUsuario usuario = g.Buscar("a");
        System.out.println("alias: "+usuario.getAlias()+", correo: "+usuario.getCorreo());
    }
}

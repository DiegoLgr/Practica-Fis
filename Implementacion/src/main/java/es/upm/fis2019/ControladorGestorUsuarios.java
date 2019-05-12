package es.upm.fis2019;
public class ControladorGestorUsuarios implements IRegistro, IBusca{

	public Boolean registrarUsuario(String alias, String correo, String pssw){
		return true;
	};
	public Boolean resetearContrasena(String correo){
		return null;
	};
	public IUsuario buscarUsuario(String alias){
		return null;
	};

}

package es.upm.fis2019;
public interface IRegistro {
	public Boolean registrarUsuario(String alias, String correo, String pssw);
	public Boolean resetearContrasena(String correo);
}

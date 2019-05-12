package es.upm.fis2019;
public interface IVerificable {
	public void CambiarAlias(String alias);
	public void RestaurarContrasena();
	public void VerificarCredenciales(String credencial, String pssw);
}

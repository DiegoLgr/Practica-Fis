package es.upm.fis2019;
public interface IAutentica {
	public Boolean verificar(String credencial, String passw);
	public Boolean cambiarAlias(String nuevoAlias);
}

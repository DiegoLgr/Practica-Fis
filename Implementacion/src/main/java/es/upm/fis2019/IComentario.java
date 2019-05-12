package es.upm.fis2019;
public interface IComentario {
	public String getId();
	public String getTexto();
	public <date> date getFecha();
	public String getRespuesta();
}

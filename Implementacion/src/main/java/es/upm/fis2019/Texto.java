package es.upm.fis2019;
public class Texto extends Contenido implements ITexto {
	private String texto;

	public Texto(String txt){
		this.texto=txt;
	}
	public String getTexto(){
		return this.texto;
	};
}

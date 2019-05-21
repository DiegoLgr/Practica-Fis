package es.upm.fis2019;
public class Enlace extends Contenido implements IEnlace {
	private String enlace;
	private String Titulo;
	private String Resumen;
	private String Imagen;

	public Enlace(String enlace){
		this.enlace=enlace;
	}

	@Override
	public String getEnlace() {
		return enlace;
	}

	@Override //no hay que hacerlo
	public String getTitulo() {
		return null;
	}

	@Override //no hay que hacerlo
	public String getImagen(){
		return null;
	};

	@Override //no hay que hacerlo
	public String GenerarResumen(){
		return null;
	};
}

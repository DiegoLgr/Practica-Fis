package es.upm.fis2019;

public class Conexion implements IEjecutador {
	private String Path;
	private String User;
	private String Mode;
	private String Pssw;
	private static Conexion conexion;

	//Constructor Privado
	private Conexion(){
		this.Path="aaa";
	}

	//Singleton
	public static Conexion getInstance(){
		if(conexion==null)
			conexion=new Conexion();

		return conexion;
	}

	public void ejecutar(String peticion){

	};
	public Boolean conectar(){
	return true;
	};


}

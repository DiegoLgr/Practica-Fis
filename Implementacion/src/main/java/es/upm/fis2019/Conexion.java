package es.upm.fis2019;
import java.sql.*;

public class Conexion implements IEjecutador {
	private String url="jdbc:sqlite:BDEspacioUpm.db";
	private String User;
	private String Mode;
	private String Pssw;
	private static Conexion conexion; //Variable del singleton
	private Connection c; //variable con el conector a la Base de datos


	//Constructor Privado
	private Conexion(){
		url="jdbc:sqlite:BDEspacioUpm.db";
	}

	//Singleton
	public static Conexion getInstance(){
		if(conexion==null)
			conexion=new Conexion();

		return conexion;
	}



	//metodo para iniciar conexion a bd
	public Boolean conectar(){
		try {
			c=DriverManager.getConnection(url);
			System.out.println("Conexion establecida.");
			return true;
		}catch (SQLException e){
			System.err.println(e.getMessage());
			return false;
		}
	}
	//metodo para terminar conexion a bd
	public Boolean desconectar(){
		try {
			c.close();
			return  true;
		}catch (SQLException e){
			System.err.println(e.getMessage());
			return false;
		}
	}

	//metodo para ejecutar querys que no devuelvan nada
	public void ejecutar(String query){
		try {
			Statement st = c.createStatement();
			st.execute(query);
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}

	//metodo para ejecutar querys que devuelvan
	public ResultSet ejecutarQuery(String query) {

		ResultSet rs=null;
		try {
			Statement st = c.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}

	public static void main(String[] args) {
		Conexion c=Conexion.getInstance();
		System.out.println(c.conectar());
		System.out.println(c.desconectar());
	}
}

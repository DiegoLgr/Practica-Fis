package es.upm.fis2019;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Conexion implements IEjecutador {
	private String url;
	private String User;
	private String Mode;
	private String Pssw;
	private Connection c;
	private static Conexion conexion;

	//Constructor Privado
	private Conexion(){
		this.url="jdbc:sqlite:BDEspacioUpm.db";
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

	public void ejecutar(String query){
		try {
			Statement st = c.createStatement();
			ResultSet rs=st.executeQuery(query);
		}catch (SQLException e){
			System.out.println(e.getMessage());

		}
	}
	public ResultSet ejecutarQuery(String query) {
		/*
		ResultSet rs;
		try {
			Statement st = c.createStatement();
			rs = st.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return rs;
		}
	*/
	}


	public static void main(String[] args) {
		Conexion c=Conexion.getInstance();
		System.out.println(c.conectar());
		System.out.println(c.desconectar());
	}
}

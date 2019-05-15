package es.upm.fis2019;

import java.sql.ResultSet;

public interface IEjecutador {
	public void ejecutar(String query);
	public ResultSet ejecutarQuery(String query);
	public Boolean conectar();

}

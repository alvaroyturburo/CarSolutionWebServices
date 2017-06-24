package ec.edu.upse.model;

import java.sql.Connection;
import java.sql.SQLException;

public class DBModuloConexion {
	
	public void conexionBD(){
	DBManager dbmanager = new DBManager();
	//obtener conexion
	Connection conexion = dbmanager.getConection();
	if(conexion == null)
		{
		System.out.println("Conexion no se pudo realizar");
		}
	}
	
	public void cerrarBD(){
		DBManager dbmanager = new DBManager();
		//obtener conexion
		Connection conexion = dbmanager.getConection();
		//cerrar la conexion
			try {
			conexion.close();
				} catch (SQLException e) 
					{
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
		}

}

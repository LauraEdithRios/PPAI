package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Exposicion;
import Entidades.Sede;
import Entidades.Tarifa;
import Entidades.TipoExposicion;

public class DaoTipoExposicion {
	
	
	public static TipoExposicion obtenerTipoExposicion(int idTipoExposicion)
	{
		TipoExposicion tipoexpo = new TipoExposicion();
		
		try
		{
			Connection conexion = Conexion.getConectar();
			
			String consulta = "SELECT * FROM dbo.TipoExposicion WHERE idTipoExposicion = ?";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setInt(1, idTipoExposicion);
		    ResultSet resultado = sentencia.executeQuery();
		        
		    while(resultado.next())
		    {
		    	
		    	tipoexpo.setNombre(resultado.getString("nombre"));
		    }
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return tipoexpo ;
	}
}
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Exposicion;
import Entidades.Sede;
import Entidades.Tarifa;

public class DaoExposicion {
	
	
	public static ArrayList<Exposicion> buscarExposicionesPorSede(int idSede)
	{
		ArrayList <Exposicion> exposiciones = new ArrayList<Exposicion>();
		
		try
		{
			Connection conexion = Conexion.getConectar();
			
			String consulta = "SELECT * FROM dbo.Exposicion WHERE idSede = ?";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setInt(1, idSede);
		    ResultSet resultado = sentencia.executeQuery();
		        
		    while(resultado.next())
		    {
		    	Exposicion exposicion = new Exposicion();
		    	exposicion.setNombre(resultado.getString("nombre"));
		    	exposicion.setFechaInicio(resultado.getDate("fechaInicio"));
		    	exposicion.setFechaInicioReplanificada(resultado.getDate("fechaInicioReplanificada"));
		    	exposicion.setFechaFin(resultado.getDate("fechaFin"));
		    	exposicion.setFechaFinReplanifnicada(resultado.getDate("fechaFinReplanificada"));
		    	exposicion.setHoraApertura(resultado.getTime("HoraApertura"));
		    	exposicion.setHoraCierre(resultado.getTime("horaCierre"));
		    	exposicion.setTipoExposicion(DaoTipoExposicion.obtenerTipoExposicion(resultado.getInt("idTipoExposicion")));
		    	exposicion.setPublicoDestino(DaoEposicXPublicoDestino.obtenerPublicoPorExposicion(resultado.getInt("idTipoExposicion")));
		    	exposicion.setDetallesExposicion(DaoDetalleExposicion.arrayObrasPorExposicion(resultado.getInt("idExposicion")));
		    	
		    	
		    	exposiciones.add(exposicion);

		    }
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return exposiciones ;
	}
}
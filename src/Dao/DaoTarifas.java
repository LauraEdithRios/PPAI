package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Sede;
import Entidades.Tarifa;

public class DaoTarifas {
	
	
	public static ArrayList<Tarifa> obtenerTarifasPorSede(int idSede)
	{
		ArrayList <Tarifa> tarifas = new ArrayList<Tarifa>();
		
		try
		{
			Connection conexion = Conexion.getConectar();
			
			String consulta = "SELECT * FROM dbo.Tarifa WHERE idSede = ?";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setInt(1, idSede);
		    ResultSet resultado = sentencia.executeQuery();
		        
		    while(resultado.next())
		    {
		    	Tarifa tarifa = new Tarifa();
		    	tarifa.setMonto(resultado.getFloat("monto"));
		    	tarifa.setMontoAdicionalGuia(resultado.getFloat("montoAdicionalPorGuia"));
		    	tarifa.setTipoDeVisitas(DaoTipoVisita.obtenerTipoVisita(resultado.getInt("idTipoVisita")));
		    	tarifas.add(tarifa);

		    }
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return tarifas ;
	}
}
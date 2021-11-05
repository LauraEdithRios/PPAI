package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoSede {
	
	public static ArrayList<Sede> arraySedes()
	{
		ArrayList <Sede> sedes = new ArrayList<Sede>();
		
		try
		{
			Connection conexion = Conexion.getConectar();
			String consulta = "SELECT *, nombre FROM dbo.SEDE";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
		    ResultSet resultado = sentencia.executeQuery();
		        
		    while(resultado.next())
		    {
		    	Sede sede = new Sede();
		    	sede.setIdsede(resultado.getInt("idsede"));
		    	sede.setNombre(resultado.getString("nombre"));
		    	sede.setCantMaxVisitates(resultado.getInt("cantMaxVisitantes"));
		    	sede.setCantMaxPorGuia(resultado.getInt("cantMaxXGuia"));
		    	sede.setHorarios(DaoSedeXHorario.buscarHorarioXSede(resultado.getInt("idsede")));
		    	sede.setTarifas(DaoTarifas.obtenerTarifasPorSede(sede.getIdsede()));
		    	sede.setExposiciones(DaoExposicion.buscarExposicionesPorSede(resultado.getInt("idsede")));
		    	sedes.add(sede);

		    }
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return sedes ;
	}
	

}

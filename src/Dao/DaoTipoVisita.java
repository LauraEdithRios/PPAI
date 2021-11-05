package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;

import Entidades.TipoVisita;

public class DaoTipoVisita {
	public static ArrayList<TipoVisita> arrayTipoVisitas()
	{
		ArrayList <TipoVisita> tipoVisitas = new ArrayList<TipoVisita>();		
		try
		{
			Connection conexion = Conexion.getConectar();			
			String consulta = "SELECT * FROM dbo.tipoVisita order by nombre";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
		    ResultSet resultado = sentencia.executeQuery();
		        
		    while(resultado.next())
		    {
		    	TipoVisita tipoVisita = new TipoVisita();
		    	tipoVisita.setNombre(resultado.getString("nombre"));
		    	tipoVisitas.add(tipoVisita);

		    }
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return tipoVisitas;
	}
	public static TipoVisita obtenerTipoVisita(int id)
	{
		TipoVisita tipoVisita = null;		
		try
		{
			Connection conexion = Conexion.getConectar();			
			String consulta = "SELECT * FROM tipoVisita WHERE id = ?";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
			sentencia.setInt(1, id);
		    ResultSet resultado = sentencia.executeQuery();		        
		    if(resultado.next())
		    {
		    	tipoVisita = new TipoVisita();
		    	tipoVisita.setNombre(resultado.getString("descripcion"));
		    }
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return tipoVisita;
	}
}

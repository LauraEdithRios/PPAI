package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoEscuela {
	
	public static ArrayList<Escuela> arrayEscuelas()
	{
		ArrayList <Escuela> escuelas = new ArrayList<Escuela>();
		
		try
		{
			Connection conexion = Conexion.getConectar();
			
			String consulta = "SELECT * FROM dbo.ESCUELA";
			PreparedStatement sentencia= conexion.prepareStatement(consulta);
		    ResultSet resultado = sentencia.executeQuery();
		        
		    while(resultado.next())
		    {
		    	Escuela escuela = new Escuela();
		    	escuela.setNombre(resultado.getString("nombre"));
		    	escuela.setDomicilio(resultado.getString("domicilio"));
		    	escuela.setEmail(resultado.getString("mail"));
		    	escuela.setTelCel(resultado.getInt("telCelular"));
		    	escuela.setTelFijo(resultado.getInt("telFijo"));
		    	
		    	escuelas.add(escuela);

		    }
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return escuelas;
	}
	

}

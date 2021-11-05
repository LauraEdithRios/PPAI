package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.Conexion;
import Entidades.Obra;

public class DaoObra {

		public static Obra obtenerObra(int idObra) {
			Obra obra = null;

			try {
				Connection conexion = Conexion.getConectar();

				String consulta = "SELECT * FROM dbo.Obra WHERE idObra = ?";
				PreparedStatement sentencia = conexion.prepareStatement(consulta);
				sentencia.setInt(1, idObra);
				ResultSet resultado = sentencia.executeQuery();

				if (resultado.next()) {					
					obra = new Obra();
					obra.setAlto(resultado.getInt("alto"));
					obra.setAncho(resultado.getInt("ancho"));
					obra.setCodigoSensor(resultado.getInt("codigoSensor"));
					obra.setDuracionExtendida(resultado.getInt("duracionExtendida"));
					obra.setDuracionResumida(resultado.getInt("duracionResumida"));
					obra.setFechaCreacion(resultado.getDate("fechaCreacion"));
					obra.setFechaPrimerIngreso(resultado.getDate("fechaPrimerIngreso"));
					obra.setNombreObra(resultado.getString("nombreObra"));
					obra.setPeso(resultado.getFloat("peso"));
					obra.setValuacipon(resultado.getInt("valuacion"));
					obra.setDescripcion(resultado.getString("descripcion"));
					
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
			return obra;
		}
}


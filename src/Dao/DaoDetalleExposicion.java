package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoDetalleExposicion {

	public static ArrayList<DetalleExposicion> arrayObrasPorExposicion(int idExposicion) {
		ArrayList<DetalleExposicion> detallesExposiciones = new ArrayList<DetalleExposicion>();

		try {
			Connection conexion = Conexion.getConectar();

			String consulta = "SELECT * FROM dbo.DetalleExposicion WHERE idExposicion = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idExposicion);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				DetalleExposicion detalle = new DetalleExposicion();
				detalle.setLugarAsignado(resultado.getString("lugarAsignado"));				
				detalle.setObra(DaoObra.obtenerObra(resultado.getInt("idObra")));
				detallesExposiciones.add(detalle);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return detallesExposiciones;
	}
}

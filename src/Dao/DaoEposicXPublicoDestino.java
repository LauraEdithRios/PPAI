package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoEposicXPublicoDestino {

	public static ArrayList<PublicoDestino> obtenerPublicoPorExposicion( int idExposicion) {
		ArrayList<PublicoDestino> publicoDestinos = new ArrayList<PublicoDestino>();

		try {
			Connection conexion = Conexion.getConectar();

			String consulta = "SELECT * FROM dbo.ExposicionXPublicoDestino exp, dbo.PublicoDestino pd WHERE exp.idPublicoDestino = pd.idPD AND exp.idExposicion = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idExposicion);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				PublicoDestino publico = new PublicoDestino();
				publico.setNombre(resultado.getString("descripcion"));
				publicoDestinos.add(publico);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return publicoDestinos;
	}

}

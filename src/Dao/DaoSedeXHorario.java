package Dao;

import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import Entidades.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoSedeXHorario {

	public static ArrayList<SedeXHorario> buscarHorarioXSede(int idsede) {
		ArrayList<SedeXHorario> horarios = new ArrayList<SedeXHorario>();

		try {
			Connection conexion = Conexion.getConectar();

			String consulta = "SELECT h.horaApertura, h.horaCierre FROM dbo.SEDE s, dbo.SedeXHorario sh, dbo.HORARIO h WHERE s.idsede = sh.idSede AND sh.idHorario = h.idHorario"
					+ " AND s.idsede =" + idsede +";";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				SedeXHorario sedeXHorario = new SedeXHorario();
				HorarioSede horario = new HorarioSede();
				horario.setHoraApertura(resultado.getTime("horaApertura"));
				horario.setHoraCierre(resultado.getTime("horaCierre"));
				sedeXHorario.setHorarios(horario);

				horarios.add(sedeXHorario);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return horarios;
	}

}

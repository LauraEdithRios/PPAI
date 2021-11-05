package Entidades;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;

public class HorarioEmpleado {
	
	private Time horaIngreso;
	private Time horaSalida;
	private ArrayList <DiaSemana> diaSemana;
	
	public Time getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(Time horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public Time getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}
	public ArrayList<DiaSemana> getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(ArrayList<DiaSemana> diaSemana) {
		this.diaSemana = diaSemana;
	}
	@Override
	public int hashCode() {
		return Objects.hash(diaSemana, horaIngreso, horaSalida);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HorarioEmpleado other = (HorarioEmpleado) obj;
		return Objects.equals(diaSemana, other.diaSemana) && Objects.equals(horaIngreso, other.horaIngreso)
				&& Objects.equals(horaSalida, other.horaSalida);
	}
	@Override
	public String toString() {
		return "HorarioEmpleado [horaIngreso=" + horaIngreso + ", horaSalida=" + horaSalida + ", diaSemana=" + diaSemana
				+ "]";
	}

}

package Entidades;

import java.sql.Time;
import java.util.ArrayList;

public class HorarioSede {
	
	private Time horaApertura;
	private Time horaCierre;
	private ArrayList <DiaSemana> diasSemana;
	
	
	public Time getHoraApertura() {
		return horaApertura;
	}
	public void setHoraApertura(Time horaApertura) {
		this.horaApertura = horaApertura;
	}
	public Time getHoraCierre() {
		return horaCierre;
	}
	public void setHoraCierre(Time horaCierre) {
		this.horaCierre = horaCierre;
	}
	public ArrayList<DiaSemana> getDiasSemana() {
		return diasSemana;
	}
	public void setDiasSemana(ArrayList<DiaSemana> diasSemana) {
		this.diasSemana = diasSemana;
	}
}

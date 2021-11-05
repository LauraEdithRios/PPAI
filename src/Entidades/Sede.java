package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Sede {
	
	private int idsede;
	private String nombre;
	private int cantMaxVisitates;
	private int cantMaxPorGuia;
	private ArrayList <SedeXHorario> horarios;
	private ArrayList <Tarifa> tarifas;
	private ArrayList <Exposicion> exposiciones;//array que contiene todas las esposiciones vigentes
	
	public ArrayList<Exposicion> getExposiciones() {
		return exposiciones;
	}
	public void setExposiciones(ArrayList<Exposicion> exposiciones) {
		this.exposiciones = exposiciones;
	}
	public int getIdsede() {
		return idsede;
	}
	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}
	public ArrayList<SedeXHorario> getHorarios() {
		return horarios;
	}
	public void setHorarios(ArrayList<SedeXHorario> horarios) {
		this.horarios = horarios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantMaxVisitates() {
		return cantMaxVisitates;
	}
	public void setCantMaxVisitates(int cantMaxVisitates) {
		this.cantMaxVisitates = cantMaxVisitates;
	}
	public int getCantMaxPorGuia() {
		return cantMaxPorGuia;
	}
	public void setCantMaxPorGuia(int cantMaxPorGuia) {
		this.cantMaxPorGuia = cantMaxPorGuia;
	}
	
	public ArrayList<Tarifa> getTarifas() {
		return tarifas;
	}
	public void setTarifas(ArrayList<Tarifa> tarifa) {
		this.tarifas = tarifa;
	}
	public ArrayList <TipoVisita> conocerTipoVisita(){
		ArrayList<TipoVisita> tipoVisitas = new ArrayList<TipoVisita>();
 		for(Tarifa tarifa : tarifas){
 			TipoVisita tipoVisita = tarifa.getTipoDeVisita();
 			if(!tipoVisitas.contains(tipoVisita)){
 				tipoVisitas.add(tipoVisita);
 			}
 		}
 		return tipoVisitas;
	}
	
	public ArrayList <Exposicion> conocerExposiciones(Date fechaActual){//Devuelve las exposiciones que estan vigentes
		
		ArrayList<Exposicion> expoVigentes = new ArrayList<Exposicion>();
 		for(Exposicion expo : exposiciones){
 			if(expo.esVigente(fechaActual)){
 				expoVigentes.add(expo);
 			}
 		}
 		return expoVigentes;
	}
	
	public String toString()
	{
		return nombre;
	}
	
	public ArrayList<Empleado> conocerGuias(ArrayList<Exposicion> expoSelecciondada,int duracionEstimada, Date fechaReserva, Time horaReserva)
	{
		ArrayList<Empleado> empleadosDisponibles = new ArrayList<Empleado>();
		for(Exposicion expo : expoSelecciondada){
			empleadosDisponibles.add(expo.conocerGuia( duracionEstimada, fechaReserva, horaReserva ));
		}
		
		return empleadosDisponibles;
	}
	
}

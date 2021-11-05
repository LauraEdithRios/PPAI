package Entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import Dao.DaoDetalleExposicion;
import Strategy.EstrategiaCalculoDuracion;


public class Exposicion {
	
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaInicioReplanificada;
	private Date fechaFinReplanifnicada;
	private Time horaApertura;
	private Time horaCierre;
	private String nombre;
	private TipoExposicion tipoExposicion;
	private ArrayList<PublicoDestino> publicoDestino;
	private ArrayList<DetalleExposicion> detallesExposicion;
	private ArrayList<Empleado> guia;
	
	public ArrayList<Empleado> getGuia() {
		return guia;
	}
	public void setGuia(ArrayList<Empleado> guia) {
		this.guia = guia;
	}
	public ArrayList<DetalleExposicion> getDetallesExposicion() {
		return detallesExposicion;
	}
	public void setDetallesExposicion(ArrayList<DetalleExposicion> detallesExposicion) {
		this.detallesExposicion = detallesExposicion;
	}
	public TipoExposicion getTipoExposicion() {
		return tipoExposicion;
	}
	public void setTipoExposicion(TipoExposicion tipoExposicion) {
		this.tipoExposicion = tipoExposicion;
	}
	public ArrayList<PublicoDestino> getPublicoDestino() {
		return publicoDestino;
	}
	public void setPublicoDestino(ArrayList<PublicoDestino> publicoDestino) {
		this.publicoDestino = publicoDestino;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaInicioReplanificada() {
		return fechaInicioReplanificada;
	}
	public void setFechaInicioReplanificada(Date fechaInicioReplanificada) {
		this.fechaInicioReplanificada = fechaInicioReplanificada;
	}
	public Date getFechaFinReplanifnicada() {
		return fechaFinReplanifnicada;
	}
	public void setFechaFinReplanifnicada(Date fechaFinReplanifnicada) {
		this.fechaFinReplanifnicada = fechaFinReplanifnicada;
	}
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean esVigente(Date fechaActual)
	{
		if(tipoExposicion.getNombre().equals("Temporal") && fechaInicio.before(fechaActual) && fechaFin.after(fechaActual) )
		{
			return true;	
		}	
		return false;
	}
	
	public int buscarDuracionObra(EstrategiaCalculoDuracion estrategia)
	{
		return estrategia.calcularDuracionEstimada(this.getDetallesExposicion());
	}
	
	public Empleado conocerGuia( int duracionEstimada, Date fechaReserva,Time horaReserva )
	{
		if (guia.getCargo().getNombre().equals("Guia"))
		{
			
		}
		
		return guia;
	}
	
}
	


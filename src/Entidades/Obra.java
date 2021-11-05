package Entidades;

import java.sql.Date;
import java.util.Objects;

public class Obra {
	
	private int alto;
	private int ancho;
	private int codigoSensor;
	private String descripcion;
	private int duracionExtendida;
	private int duracionResumida;
	private Date fechaCreacion;
	private Date fechaPrimerIngreso;
	private String nombreObra;
	private float peso;
	private int valuacipon;
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getCodigoSensor() {
		return codigoSensor;
	}
	public void setCodigoSensor(int codigoSensor) {
		this.codigoSensor = codigoSensor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDuracionExtendida() {
		return duracionExtendida;
	}
	public void setDuracionExtendida(int duracionExtendida) {
		this.duracionExtendida = duracionExtendida;
	}
	public int getDuracionResumida() {
		return duracionResumida;
	}
	public void setDuracionResumida(int duracionResumida) {
		this.duracionResumida = duracionResumida;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaPrimerIngreso() {
		return fechaPrimerIngreso;
	}
	public void setFechaPrimerIngreso(Date fechaPrimerIngreso) {
		this.fechaPrimerIngreso = fechaPrimerIngreso;
	}
	public String getNombreObra() {
		return nombreObra;
	}
	public void setNombreObra(String nombreObra) {
		this.nombreObra = nombreObra;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getValuacipon() {
		return valuacipon;
	}
	public void setValuacipon(int valuacipon) {
		this.valuacipon = valuacipon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alto, ancho, codigoSensor, descripcion, duracionExtendida, duracionResumida, fechaCreacion,
				fechaPrimerIngreso, nombreObra, peso, valuacipon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Obra other = (Obra) obj;
		return alto == other.alto && ancho == other.ancho && codigoSensor == other.codigoSensor
				&& Objects.equals(descripcion, other.descripcion) && duracionExtendida == other.duracionExtendida
				&& duracionResumida == other.duracionResumida && Objects.equals(fechaCreacion, other.fechaCreacion)
				&& Objects.equals(fechaPrimerIngreso, other.fechaPrimerIngreso)
				&& Objects.equals(nombreObra, other.nombreObra)
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso) && valuacipon == other.valuacipon;
	}
	
	public String toString()
	{
		return nombreObra;
	}
	
	
	

}

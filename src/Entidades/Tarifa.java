package Entidades;

import java.util.ArrayList;
import java.sql.Date;

public class Tarifa {
	
	private Date fechaFinVigencia;
	private Date fechaInicioVigencia;
	private float monto;
	private float montoAdicionalGuia;
	private TipoVisita tipoDeVisita;
	//private ArrayList<TipoEntrada> tiposDeEntradas;
	
	
	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}
	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}
	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public double getMontoAdicionalGuia() {
		return montoAdicionalGuia;
	}
	public void setMontoAdicionalGuia(float montoAdicionalGuia) {
		this.montoAdicionalGuia = montoAdicionalGuia;
	}
	public TipoVisita getTipoDeVisita() {
		return tipoDeVisita;
	}
	public void setTipoDeVisitas(TipoVisita tipoDeVisita) {
		this.tipoDeVisita = tipoDeVisita;
	}
}

package Entidades;

import java.sql.Date;
import java.util.Objects;

public class AsignacionVisita {
	
	private Date fechaHoraInicio;
	private Date fechaHoraFin;
	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	public Date getFechaHoraFin() {
		return fechaHoraFin;
	}
	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaHoraFin, fechaHoraInicio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionVisita other = (AsignacionVisita) obj;
		return Objects.equals(fechaHoraFin, other.fechaHoraFin)
				&& Objects.equals(fechaHoraInicio, other.fechaHoraInicio);
	}
	@Override
	public String toString() {
		return "AsignacionVisita [fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFin=" + fechaHoraFin + "]";
	}
	
	

}

package Entidades;

import java.util.Objects;

public class DetalleExposicion {
	
	private String lugarAsignado;
	private Obra obra;
	private Pared pared;
	public String getLugarAsignado() {
		return lugarAsignado;
	}
	public void setLugarAsignado(String lugarAsignado) {
		this.lugarAsignado = lugarAsignado;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public Pared getPared() {
		return pared;
	}
	public void setPared(Pared pared) {
		this.pared = pared;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lugarAsignado, obra, pared);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleExposicion other = (DetalleExposicion) obj;
		return Objects.equals(lugarAsignado, other.lugarAsignado) && Objects.equals(obra, other.obra)
				&& Objects.equals(pared, other.pared);
	}
	
	

}

package Entidades;

import java.util.Objects;

public class PublicoDestino {
	
	private String caracteristicas;
	private String nombre;
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String toString() {
		return nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(caracteristicas, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublicoDestino other = (PublicoDestino) obj;
		return Objects.equals(caracteristicas, other.caracteristicas) && Objects.equals(nombre, other.nombre);
	}

}

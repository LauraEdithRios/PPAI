package Entidades;

import java.util.Objects;

public class TipoExposicion {
	
	private String descripcion;
	private String nombre;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString()
	{
		return nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoExposicion other = (TipoExposicion) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre);
	}

}

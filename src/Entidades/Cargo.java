package Entidades;

import java.util.Objects;

public class Cargo {
	
	private String nombre;
	private String descripcion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		Cargo other = (Cargo) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Cargo [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}

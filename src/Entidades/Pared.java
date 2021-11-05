package Entidades;

import java.util.Objects;

public class Pared {
	
	private int alto;
	private int ancho;
	private String nombre;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public int hashCode() {
		return Objects.hash(alto, ancho, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pared other = (Pared) obj;
		return alto == other.alto && ancho == other.ancho && Objects.equals(nombre, other.nombre);
	}

}

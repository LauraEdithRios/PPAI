package Entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;


public class Empleado {
	
	private String apellido;
	private int codigoVal;
	private int cuil;
	private int dni;
	private String domicilio;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private String mail;
	private String nombre;
	private String sexo;
	private Cargo cargo;
	private ArrayList<HorarioEmpleado> horariosEmpleado;
	private ArrayList<AsignacionVisita> asignaciones = null;
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCodigoVal() {
		return codigoVal;
	}
	public void setCodigoVal(int codigoVal) {
		this.codigoVal = codigoVal;
	}
	public int getCuil() {
		return cuil;
	}
	public void setCuil(int cuil) {
		this.cuil = cuil;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public ArrayList<HorarioEmpleado> getHorariosEmpleado() {
		return horariosEmpleado;
	}
	public void setHorariosEmpleado(ArrayList<HorarioEmpleado> horariosEmpleado) {
		this.horariosEmpleado = horariosEmpleado;
	}
	public ArrayList<AsignacionVisita> getAsignaciones() {
		return asignaciones;
	}
	public void setAsignaciones(ArrayList<AsignacionVisita> asignaciones) {
		this.asignaciones = asignaciones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, asignaciones, cargo, codigoVal, cuil, dni, domicilio, fechaIngreso,
				fechaNacimiento, horariosEmpleado, mail, nombre, sexo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(asignaciones, other.asignaciones)
				&& Objects.equals(cargo, other.cargo) && codigoVal == other.codigoVal && cuil == other.cuil
				&& dni == other.dni && Objects.equals(domicilio, other.domicilio)
				&& Objects.equals(fechaIngreso, other.fechaIngreso)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(horariosEmpleado, other.horariosEmpleado) && Objects.equals(mail, other.mail)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sexo, other.sexo);
	}
	
}

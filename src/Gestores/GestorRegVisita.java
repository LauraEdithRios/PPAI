package Gestores;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.DaoEscuela;
import Dao.DaoSede;
import Entidades.Empleado;
import Entidades.Escuela;
import Entidades.Exposicion;
import Entidades.Sede;
import Entidades.TipoVisita;
import Strategy.EstrategiaCalculoDuracion;
import Strategy.VisitaCompleta;
import Strategy.VisitaPorExposicion;

public class GestorRegVisita {
	
	public static Escuela escuelaSeleccionada;
	public static Sede sedeActual;
	public static int cantidadVisitantes;
	public static TipoVisita tipoVisitaSeleccionado;
	public static ArrayList<Exposicion> exposicionesVIGENTES;
	public static EstrategiaCalculoDuracion strategy;
	public static int duracionEstimada;
	private static boolean capacidadPermitida;
	private static Date fechaReserva;
	private static Time horaReserva;
	
	public static Date getFechaReserva() {
		return fechaReserva;
	}

	public static void setFechaReserva(Date fechaReserva) {
		GestorRegVisita.fechaReserva = fechaReserva;
	}

	public static Time getHoraReserva() {
		return horaReserva;
	}

	public static void setHoraReserva(Time horaReserva) {
		GestorRegVisita.horaReserva = horaReserva;
	}

	public static int getDuracionEstimada() {
		return duracionEstimada;
	}

	public static void setDuracionEstimada(int duracionEstimada) {
		GestorRegVisita.duracionEstimada = duracionEstimada;
	}

	public static boolean isCapacidadPermitida() {
		return capacidadPermitida;
	}

	public static void setCapacidadPermitida(boolean capacidadPermitida) {
		GestorRegVisita.capacidadPermitida = capacidadPermitida;
	}

	public static ArrayList<Exposicion> getExposicionesVIGENTES() {
		return exposicionesVIGENTES;
	}

	public static void setExposicionesVIGENTES(ArrayList<Exposicion> exposicionesVIGENTES) {
		GestorRegVisita.exposicionesVIGENTES = exposicionesVIGENTES;
	}

	public static int getCantidadVisitantes() {
		return cantidadVisitantes;
	}

	public static void setCantidadVisitantes(int cantidadVisitantes) {
		GestorRegVisita.cantidadVisitantes = cantidadVisitantes;
	}

	public static TipoVisita getTipoVisitaSeleccionado() {
		return tipoVisitaSeleccionado;
	}

	public static void setTipoVisitaSeleccionado(TipoVisita tipoVisitaSeleccionado) {
		GestorRegVisita.tipoVisitaSeleccionado = tipoVisitaSeleccionado;
	}

	public static void setExposicionesSeleccionadas(ArrayList<Exposicion> exposicionesSeleccionadas) {
		GestorRegVisita.exposicionesVIGENTES = exposicionesSeleccionadas;
	}

	public static Escuela getEscuelaSeleccionada() {
		return escuelaSeleccionada;
	}

	public static void setEscuelaSeleccionada(Escuela escuelaSeleccionada) {
		GestorRegVisita.escuelaSeleccionada = escuelaSeleccionada;
	}

	public static Sede getSedeActual() {
		return sedeActual;
	}

	public static void setSedeActual(Sede sedeActual) {
		GestorRegVisita.sedeActual = sedeActual;
	}

	public static ArrayList <Escuela> buscarEscuela()
	{
		return DaoEscuela.arrayEscuelas();
	}
	
	public static ArrayList <Sede> buscarSede()
	{
		return DaoSede.arraySedes();
	}
	
	public static void tomarSeleccionEscuela(Object escSeleccionada)
	{
		escuelaSeleccionada = (Escuela) escSeleccionada;
	}
	
	public static void tomarSeleccionSede(Object sedeSeleccionada)
	{
		sedeActual = (Sede) sedeSeleccionada;
	}
	
	public static void tomarCantidadVisitantes(String cantVisitantes)
	{
		cantidadVisitantes = Integer.parseInt(cantVisitantes);
	}
	
	public static void tomarSeleccionTipoVisita(Object tipoVisitaSelecciona)
	{
		tipoVisitaSeleccionado = (TipoVisita) tipoVisitaSelecciona;
	}
	
	public static Date obtenerFechaActual()
	{
		
		Date fechaActual = new Date(System.currentTimeMillis());
		
		return fechaActual;	
	}
	
	public static void buscarExposicionesVigentes()
	{
		exposicionesVIGENTES = sedeActual.conocerExposiciones(obtenerFechaActual());
	}
	
	public static void tomarSeleccionExposicion(Object exposicion)
	{
		exposicionesVIGENTES.add((Exposicion) exposicion);
	}
	
	
	public static void crearStrategy()
	{
		if(tipoVisitaSeleccionado.getNombre().equals("Por Exposición"))
		{	
			strategy = new VisitaPorExposicion();	
		}
		else
		{
			strategy  = new VisitaCompleta();
		}
	}
	
	public static int calcularDuracionEstimada()
	{
		crearStrategy();
		duracionEstimada =  0;
		for (Exposicion exposicion : getExposicionesVIGENTES()) {
			duracionEstimada += exposicion.buscarDuracionObra(strategy);
		}
		return duracionEstimada;
	}
	
	
	public static Boolean validarCupoCede()
	{
		capacidadPermitida = false;
		if(sedeActual.getCantMaxVisitates() > getCantidadVisitantes() )
		{
			capacidadPermitida = true;
		}
		return capacidadPermitida;
	}
	
	public static void tomarFechaReserva( Date fecha)
	{
		fechaReserva = fecha;
	}
	
	public static void tomarHoraReserva( Time hora)
	{
		horaReserva = hora;
	}
	
	public ArrayList<Empleado> buscarGuias()
	{
		return sedeActual.conocerGuias(exposicionesVIGENTES, duracionEstimada,fechaReserva, horaReserva );
	}
}


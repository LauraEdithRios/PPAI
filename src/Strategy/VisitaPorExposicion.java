package Strategy;

import java.util.ArrayList;


import Entidades.DetalleExposicion;


public class VisitaPorExposicion implements EstrategiaCalculoDuracion 
{
	
	@Override
	public int calcularDuracionEstimada(ArrayList<DetalleExposicion> detallesExposiciones) {
		//VISITA POR EXPOSICION, SOLO SUMO LAS DURACION EXTENDIDA DE CADA OBRA UNICAMENTE
		int duracion = 0;
		for(DetalleExposicion detalle : detallesExposiciones) {
			duracion += detalle.getObra().getDuracionExtendida();
		}
		return duracion;
	}
	

}

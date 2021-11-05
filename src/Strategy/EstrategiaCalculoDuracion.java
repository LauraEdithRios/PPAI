package Strategy;

import java.util.ArrayList;

import Entidades.DetalleExposicion;
import Entidades.Exposicion;

public interface EstrategiaCalculoDuracion {
	
	int calcularDuracionEstimada(ArrayList <DetalleExposicion> detallesExposiciones);

}

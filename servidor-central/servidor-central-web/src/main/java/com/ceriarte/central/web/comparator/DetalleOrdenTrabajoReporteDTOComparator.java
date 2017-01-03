package com.ceriarte.central.web.comparator;

import java.util.Comparator;

import com.ceriarte.central.dominio.dto.DetalleOrdenTrabajoReporteDTO;

public class DetalleOrdenTrabajoReporteDTOComparator implements Comparator<DetalleOrdenTrabajoReporteDTO>{

	@Override
	public int compare(DetalleOrdenTrabajoReporteDTO o1, DetalleOrdenTrabajoReporteDTO o2) {
        return o1.getIdProducto() > o2.getIdProducto() ? 1 : (o2.getIdProducto() > o1.getIdProducto() ) ? -1 : 0;
	}

}

package com.ceriarte.central.web.comparator;

import java.util.Comparator;

import com.ceriarte.central.dominio.dto.DetallePresupuestoReporteDTO;

public class DetallePresupuestoReporteDTOComparator implements Comparator<DetallePresupuestoReporteDTO>{

	@Override
	public int compare(DetallePresupuestoReporteDTO o1, DetallePresupuestoReporteDTO o2) {
        return o1.getIdProducto() > o2.getIdProducto() ? 1 : (o2.getIdProducto() > o1.getIdProducto() ) ? -1 : 0;
	}

}

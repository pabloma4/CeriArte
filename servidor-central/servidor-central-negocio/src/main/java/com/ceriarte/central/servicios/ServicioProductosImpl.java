package com.ceriarte.central.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriarte.central.converters.ProductoConverter;
import com.ceriarte.central.converters.UnidadMedidaConverter;
import com.ceriarte.central.dominio.Producto;
import com.ceriarte.central.dominio.UnidadMedida;
import com.ceriarte.central.dominio.dto.ProductoDTO;
import com.ceriarte.central.repository.ProductoRepository;

/**
 * @author Pablo Marengo
 *
 */
@Service("servicioProductos")
@Transactional
public class ServicioProductosImpl implements ServicioProductos {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public ProductoDTO doSaveOrUpdate(ProductoDTO productoDTO) {
		logger.debug("Inicio doSaveOrUpdate() del Servicio de Productos");
		
		String nombre = productoDTO.getNombre();
		String descripcion = productoDTO.getDescripcion();
		Double medida = productoDTO.getMedida();
		Double precio = productoDTO.getPrecio();
		Double stock = productoDTO.getStock();
		Double stockMinimo = productoDTO.getStockMinimo();
		boolean elaborado = productoDTO.isElaborado();
		
		UnidadMedida unidadMedida = null != productoDTO.getUnidadMedida() ? UnidadMedidaConverter.toUnidadMedida(productoDTO.getUnidadMedida()) : null; 
		
		// Busco el Producto por id, sino lo encuentro creo uno nuevo.
		Producto producto = productoRepository.findOne(productoDTO.getId());
		if(null != producto){
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setMedida(medida);
			producto.setUnidadMedida(unidadMedida);
			producto.setFechaModificacion(new Date());
			producto.setStock(stock);
			producto.setStockMinimo(stockMinimo);
			producto.setElaborado(elaborado);
		}else{
			// Creo un objeto producto
			producto = new Producto(nombre, descripcion, medida, precio, unidadMedida, new Date(), stock, stockMinimo, elaborado);
		}
		
		// Almaceno los datos del producto
		producto = productoRepository.save(producto);
		
		logger.debug("Fin doSaveOrUpdate() del Servicio de Productos");
		return ProductoConverter.toProductoDTO(producto);
	}
	
	@Override
	public List<ProductoDTO> doFindAll() {
		logger.debug("Inicio doFindAll() del Servicio de Productos");
		
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();

		// Busco todos los productos
		Iterable<Producto> productos = productoRepository.findByBorradoIsFalse();

		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			ProductoDTO productoDTO = ProductoConverter.toProductoDTO(it.next());
			productosDTO.add(productoDTO);
		}
		
		logger.debug("Fin doFindAll() del Servicio de Productos");
		
		return productosDTO;
	}

	@Override
	public void doDelete(int id) {
		logger.debug("Inicio doDelete() del Servicio de Productos");
		
		Producto producto = productoRepository.findOne(id);
		producto.setBorrado(true);
		productoRepository.save(producto);
    	logger.debug("Se eliminó el producto " + id);
    	
		logger.debug("Fin doDelete() del Servicio de Productos");
	}

	@Override
	public ProductoDTO doFindOne(int id) {
		logger.debug("Inicio doFindOne() del Servicio de Productos");

		Producto producto = productoRepository.findOne(id);

		logger.debug("Fin doFindOne() del Servicio de Productos");
		return ProductoConverter.toProductoDTO(producto);
	}

	@Override
	public List<ProductoDTO> doFindByElaboradoIsFalse() {
		logger.debug("Inicio doFindByElaboradoIsFalse() del Servicio de Productos");
		
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();

		// Busco todos los productos
		Iterable<Producto> productos = productoRepository.findByBorradoIsFalseAndElaboradoIsFalse();

		Iterator<Producto> it = productos.iterator();
		while (it.hasNext()) {
			ProductoDTO productoDTO = ProductoConverter.toProductoDTO(it.next());
			productosDTO.add(productoDTO);
		}
		
		logger.debug("Fin doFindByElaboradoIsFalse() del Servicio de Productos");
		
		return productosDTO;
	}
}

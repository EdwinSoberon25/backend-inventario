package com.company.inventario.aplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.inventario.dominio.modelo.Producto;
import com.company.inventario.dominio.puertos.ProductoRepository;
import com.company.inventario.dominio.puertos.ProductoService;
@Service
public class ProductoServiceImpl  implements ProductoService {
	 private final ProductoRepository productoRepository;
	 
	 public ProductoServiceImpl(ProductoRepository productoRepository) {
	        this.productoRepository = productoRepository;
	    }
	 
	@Override
	public List<Producto> obtenerProductos() {
		 return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> obtenerProductoPorId(Long id) {
		 return productoRepository.findById(id);
	}

	@Override
	public void agregarProducto(Producto producto) {
	    Optional<Producto> productoExistente = productoRepository.findByNombre(producto.getNombre());

	    if (productoExistente.isPresent()) {
	        throw new RuntimeException("El producto con nombre '" + producto.getNombre() + "' ya existe.");
	    }

	    productoRepository.save(producto);
	}


	@Override
	public void eliminarProducto(Long id) {
		 productoRepository.delete(id);
		
	}

	@Override
	public void editarProducto(Producto producto) {
		if (productoRepository.findById(producto.getId()).isPresent()) {
	        productoRepository.save(producto);
	    } else {
	        throw new RuntimeException("Producto no encontrado con ID: " + producto.getId());
	    }
		
	}

	@Override
	public boolean existeProductoPorNombre(String nombre) {
		return productoRepository.findByNombre(nombre).isPresent();
	}
	
	

}

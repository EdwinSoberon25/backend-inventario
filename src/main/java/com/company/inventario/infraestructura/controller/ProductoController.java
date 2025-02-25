package com.company.inventario.infraestructura.controller;

import org.springframework.web.bind.annotation.*;

import com.company.inventario.dominio.modelo.Producto;
import com.company.inventario.dominio.puertos.ProductoService;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoController {

	 private final ProductoService productoService;

	    public ProductoController(ProductoService productoService) {
	        this.productoService = productoService;
	    }

	    @GetMapping
	    public List<Producto> obtenerProductos() {
	        return productoService.obtenerProductos();
	    }

	    @GetMapping("/{id}")
	    public Optional<Producto> obtenerProductoPorId(@PathVariable Long id) {
	        return productoService.obtenerProductoPorId(id);
	    }

	    @PostMapping
	    public void agregarProducto(@RequestBody Producto producto) {
	        productoService.agregarProducto(producto);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminarProducto(@PathVariable Long id) {
	        productoService.eliminarProducto(id);
	    }
}

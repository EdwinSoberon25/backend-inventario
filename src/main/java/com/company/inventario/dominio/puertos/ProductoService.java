package com.company.inventario.dominio.puertos;

import java.util.List;
import java.util.Optional;

import com.company.inventario.dominio.modelo.Producto;

public interface ProductoService {

	List<Producto> obtenerProductos();
    Optional<Producto> obtenerProductoPorId(Long id);
    void agregarProducto(Producto producto);
    void eliminarProducto(Long id); 
    void editarProducto(Producto producto);
    boolean existeProductoPorNombre(String nombre);

}

package com.company.inventario.dominio.puertos;

import java.util.List;
import java.util.Optional;

import com.company.inventario.dominio.modelo.Producto;

public interface ProductoRepository {
	 	List<Producto> findAll();
	    Optional<Producto> findById(Long id);
	    void save(Producto producto);
	    void delete(Long id);

}

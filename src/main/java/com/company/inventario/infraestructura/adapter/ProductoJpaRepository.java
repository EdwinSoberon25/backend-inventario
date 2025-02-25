package com.company.inventario.infraestructura.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.company.inventario.dominio.modelo.Producto;
import com.company.inventario.dominio.puertos.ProductoRepository;
import com.company.inventario.infraestructura.repositorio.SpringDataProductoRepository;
@Repository
public class ProductoJpaRepository implements ProductoRepository {

	  private final SpringDataProductoRepository repository;
	  
	  public ProductoJpaRepository(SpringDataProductoRepository repository) {
	        this.repository = repository;
	    }
	    
	@Override
	public List<Producto> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Producto> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(Producto producto) {
		repository.save(producto);
		
	}

	@Override
	public void delete(Long id) {
		 repository.deleteById(id);
		
	}

}

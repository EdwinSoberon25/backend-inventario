package com.company.inventario.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.inventario.dominio.modelo.Producto;

public interface SpringDataProductoRepository extends JpaRepository<Producto, Long> {

}

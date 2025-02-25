package com.company.inventario.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.company.inventario.dominio.modelo.Producto;
import com.company.inventario.dominio.puertos.ProductoService;
import com.company.inventario.infraestructura.controller.ProductoController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(ProductoController.class)  // Indica que estamos probando un controlador
@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {
	 @Autowired
	    private MockMvc mockMvc;

	    @Mock
	    private ProductoService productoService;

	    @InjectMocks
	    private ProductoController productoController;

	    @Test
	    void obtenerProductos_DeberiaRetornarListaDeProductos() throws Exception {
	        // Arrange: Simular productos
	        List<Producto> productos = Arrays.asList(
	            new Producto(1L, "Laptop", 5, 1500.0),
	            new Producto(2L, "Mouse", 10, 50.0)
	        );

	        // Simular respuesta del servicio
	        when(productoService.obtenerProductos()).thenReturn(productos);

	        // Iniciar MockMvc
	        mockMvc = MockMvcBuilders.standaloneSetup(productoController).build();

	        // Act & Assert: Hacer petición y validar respuesta
	        mockMvc.perform(MockMvcRequestBuilders.get("/productos"))
	            .andExpect(status().isOk())  // Código 200
	            .andExpect(jsonPath("$.size()").value(2))  // Verifica que haya 2 productos
	            .andExpect(jsonPath("$[0].nombre").value("Laptop"))
	            .andExpect(jsonPath("$[1].nombre").value("Mouse"));
	    
	    }
}

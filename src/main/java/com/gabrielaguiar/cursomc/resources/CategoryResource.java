package com.gabrielaguiar.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielaguiar.cursomc.domain.Category;
import com.gabrielaguiar.cursomc.services.CategoryService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	
	@RequestMapping(value="{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { // recebendo o id vindo da url

		Category obj = service.buscar(id);
		return ResponseEntity.ok().body(obj); //ira retornar objetos http
		
//		Categoria cat1 = new Categoria(1, "Informática");
//		Categoria cat2 = new Categoria(2, "Escritório");
//
//		List<Categoria> lista = new ArrayList<>();
//		lista.add(cat1);
//		lista.add(cat2);
//
//		return lista;

	}

}

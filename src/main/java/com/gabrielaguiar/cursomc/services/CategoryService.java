	package com.gabrielaguiar.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielaguiar.cursomc.domain.Category;
import com.gabrielaguiar.cursomc.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	// Essa chamada estava sendo usada abaixo do Java 8
//	public Categoria buscar(Integer id) {
//		Categoria obj = repo.findOne(id);
//		return obj;
//	}
	
	public Category find(Integer id){
		Optional<Category> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new com.gabrielaguiar.cursomc.services.exceptions.ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}

	public Category insert(Category obj) {		
		return repo.save(obj);
	}

}

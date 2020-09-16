package com.gabrielaguiar.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielaguiar.cursomc.domain.Categoria;
import com.gabrielaguiar.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	// Essa chamada estava sendo usada abaixo do Java 8
//	public Categoria buscar(Integer id) {
//		Categoria obj = repo.findOne(id);
//		return obj;
//	}
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}

package com.gabrielaguiar.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielaguiar.cursomc.domain.State;

@Repository
public interface StateRepository  extends JpaRepository<State, Integer>{	
	

}

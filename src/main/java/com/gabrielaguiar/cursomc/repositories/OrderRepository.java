package com.gabrielaguiar.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielaguiar.cursomc.domain.Order;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer>{	
	

}

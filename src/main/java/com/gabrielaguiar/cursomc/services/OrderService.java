package com.gabrielaguiar.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielaguiar.cursomc.domain.Order;
import com.gabrielaguiar.cursomc.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;	

	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.gabrielaguiar.cursomc.services.exceptions.ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Order.class.getName()));
	}

}

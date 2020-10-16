package com.gabrielaguiar.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielaguiar.cursomc.domain.Payment;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Integer>{	
	

}

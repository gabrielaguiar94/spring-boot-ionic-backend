package com.gabrielaguiar.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.gabrielaguiar.cursomc.domain.enums.StatePayment;

@Entity
public class PaymentWithBill extends Payment {
	private static final long serialVersionUID = 1L;

	private Date dateOverdue;
	private Date datePayment;

	public PaymentWithBill() {

	}

	public PaymentWithBill(Integer id, StatePayment state, Order order, Date dateOverdue, Date datePayment) {
		super(id, state, order);
		this.datePayment = datePayment;
		this.dateOverdue = dateOverdue;

	}

	public Date getDateOverdue() {
		return dateOverdue;
	}

	public void setDateOverdue(Date dateOverdue) {
		this.dateOverdue = dateOverdue;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

}

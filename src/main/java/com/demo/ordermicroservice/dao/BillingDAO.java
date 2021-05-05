package com.demo.ordermicroservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.ordermicroservice.db.model.Billing;

public interface BillingDAO extends CrudRepository<Billing, Integer> {

	Billing findById(String paymentId);
	
}

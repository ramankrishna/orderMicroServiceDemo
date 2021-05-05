package com.demo.ordermicroservice.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.demo.ordermicroservice.db.model.Payment;


public interface PaymentDAO extends CrudRepository<Payment, Integer> {
	
	ArrayList<Payment> findAllByOrderId(int id);

	Payment findById(int id);

}

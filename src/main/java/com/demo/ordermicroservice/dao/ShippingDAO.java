package com.demo.ordermicroservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.ordermicroservice.db.model.Shipping;

public interface ShippingDAO extends CrudRepository<Shipping, Integer> {

	Shipping findById(String paymentId);

}

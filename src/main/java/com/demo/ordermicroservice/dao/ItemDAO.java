package com.demo.ordermicroservice.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.demo.ordermicroservice.db.model.Item;

public interface ItemDAO extends CrudRepository<Item, Integer> {
	
	ArrayList<Item> findAllByOrderId(int id);

}

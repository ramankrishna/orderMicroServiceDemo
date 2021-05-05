package com.demo.ordermicroservice.dao;


import org.springframework.data.repository.CrudRepository;

import com.demo.ordermicroservice.db.model.*;

public interface OrderDAO extends CrudRepository<Order, Integer>{

	
}

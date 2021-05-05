package com.demo.ordermicroservice.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.ordermicroservice.resource.OrderResource;

import javax.ws.rs.ApplicationPath;
	/**
	 * This is Jersey Configuration , Add the resource classes here
	 */
	@Component
	@ApplicationPath("/")
	public class JerseyConfiguration extends ResourceConfig {

	    @Autowired
	    public JerseyConfiguration(){

	        register(OrderResource.class);


	    }

	}

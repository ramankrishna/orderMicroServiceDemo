package com.demo.ordermicroservice.resource;

import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.ordermicroservice.dao.OrderDAO;
import com.demo.ordermicroservice.service.OrderService;

@Path("/orderms")
public class OrderResource {
	
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	OrderService orderService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getOrderById/{id}")
	public Response getOrderById(@PathParam("id") int id) {
		
		Object order=null;
		order = orderService.getOrderFromDB(id);
		return Response.accepted(order).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createOrders")
	public Response createOrder(@RequestBody Map<String, Object> orderFields) {
		
		int id = orderService.orderSaveToDb(orderFields);
		return Response.accepted("This is from createOrder"+id).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cancelOrder/{id}")
	public Response cancelOrder(@PathParam("id") int id) {
		orderService.deleteFromDB(id);
		return Response.accepted("Your order has been successfully cancelled : "+id).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/batchOrders")
	public Response insertLargeData(@RequestBody Object object) {
	    orderService.insertLargeDataInDB(object); 
		return Response.accepted("Your orders has been successfully Inserted !!").build();

	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateOrders")
	public Response updateLargeData(@RequestBody Object object) {
	    orderService.updateLargeOrderDataById(object); 
		return Response.accepted("Your orders has been successfully updated !!").build();

	}
	
	

}

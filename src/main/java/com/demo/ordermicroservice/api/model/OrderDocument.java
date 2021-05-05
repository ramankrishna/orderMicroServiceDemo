package com.demo.ordermicroservice.api.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.demo.ordermicroservice.db.model.Billing;
import com.demo.ordermicroservice.db.model.Item;
import com.demo.ordermicroservice.db.model.Order;
import com.demo.ordermicroservice.db.model.Payment;
import com.demo.ordermicroservice.db.model.Shipping;

public class OrderDocument implements Serializable{

	private static final long serialVersionUID = 8189539795265129790L;

	Order order;
	
	ArrayList<Item> items;
	
	ArrayList<Payment> payments;
	
	Billing billing;
	
	Shipping shipping;

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * @return the payments
	 */
	public ArrayList<Payment> getPayments() {
		return payments;
	}

	/**
	 * @param payments the payments to set
	 */
	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}

	/**
	 * @return the billing
	 */
	public Billing getBilling() {
		return billing;
	}

	/**
	 * @param billing the billing to set
	 */
	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	/**
	 * @return the shipping
	 */
	public Shipping getShipping() {
		return shipping;
	}

	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	
	

}

package com.demo.ordermicroservice.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "items_data")
public class Item {

       @Id
	   String itemID;
	   int orderId;
	   String orderItemName;
	   int orderItemQuantity;
	   
	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderItemName
	 */
	public String getOrderItemName() {
		return orderItemName;
	}
	/**
	 * @param orderItemName the orderItemName to set
	 */
	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}
	/**
	 * @return the orderItemQuantity
	 */
	public int getOrderItemQuantity() {
		return orderItemQuantity;
	}
	/**
	 * @param orderItemQuantity the orderItemQuantity to set
	 */
	public void setOrderItemQuantity(int orderItemQuantity) {
		this.orderItemQuantity = orderItemQuantity;
	}
	

}

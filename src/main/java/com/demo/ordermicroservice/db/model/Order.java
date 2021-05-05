package com.demo.ordermicroservice.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "orders_data")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;     
	
    int orderCustomerId;
    
    String orderStatus;
    
    String orderItemId ;
    
    String orderTax; 
    
    String orderTotal;
    
    String paymentId;
    
    Date orderCreateDate;   
    
    Date orderModifiedDate;

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
	 * @return the orderCustomerId
	 */
	public int getOrderCustomerId() {
		return orderCustomerId;
	}

	/**
	 * @param orderCustomerId the orderCustomerId to set
	 */
	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the orderItemId
	 */
	public String getOrderItemId() {
		return orderItemId;
	}

	/**
	 * @param orderItemId the orderItemId to set
	 */
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	/**
	 * @return the orderTax
	 */
	public String getOrderTax() {
		return orderTax;
	}

	/**
	 * @param orderTax the orderTax to set
	 */
	public void setOrderTax(String orderTax) {
		this.orderTax = orderTax;
	}

	/**
	 * @return the orderTotal
	 */
	public String getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the orderCreateDate
	 */
	public Date getOrderCreateDate() {
		return orderCreateDate;
	}

	/**
	 * @param orderCreateDate the orderCreateDate to set
	 */
	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}

	/**
	 * @return the orderModifiedDate
	 */
	public Date getOrderModifiedDate() {
		return orderModifiedDate;
	}

	/**
	 * @param orderModifiedDate the orderModifiedDate to set
	 */
	public void setOrderModifiedDate(Date orderModifiedDate) {
		this.orderModifiedDate = orderModifiedDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCustomerId=" + orderCustomerId + ", orderStatus=" + orderStatus
				+ ", orderItemId=" + orderItemId + ", orderTax=" + orderTax + ", orderTotal=" + orderTotal
				+ ", paymentId=" + paymentId + ", orderCreateDate=" + orderCreateDate + ", orderModifiedDate="
				+ orderModifiedDate + "]";
	} 

	
	
	

}

package com.demo.ordermicroservice.db.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "payments_data")
public class Payment {
	
	   @Id
	   String paymentId;
	   int customerId;
	   String orderPaymentMethod;
	   Date orderPaymentDate;
	   Date orderConfirmationDate;
	   int orderId;
	   String billingId;
	   String shippingId;
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
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the orderPaymentDate
	 */
	public Date getOrderPaymentDate() {
		return orderPaymentDate;
	}
	/**
	 * @param orderPaymentDate the orderPaymentDate to set
	 */
	public void setOrderPaymentDate(Date orderPaymentDate) {
		this.orderPaymentDate = orderPaymentDate;
	}
	/**
	 * @return the orderConfirmationDate
	 */
	public Date getOrderConfirmationDate() {
		return orderConfirmationDate;
	}
	/**
	 * @param orderConfirmationDate the orderConfirmationDate to set
	 */
	public void setOrderConfirmationDate(Date orderConfirmationDate) {
		this.orderConfirmationDate = orderConfirmationDate;
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
	 * @return the billingId
	 */
	public String getBillingId() {
		return billingId;
	}
	/**
	 * @param billingId the billingId to set
	 */
	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}
	/**
	 * @return the shippingId
	 */
	public String getShippingId() {
		return shippingId;
	}
	/**
	 * @param shippingId the shippingId to set
	 */
	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}
	/**
	 * @return the orderPaymentMethod
	 */
	public String getOrderPaymentMethod() {
		return orderPaymentMethod;
	}
	/**
	 * @param orderPaymentMethod the orderPaymentMethod to set
	 */
	public void setOrderPaymentMethod(String orderPaymentMethod) {
		this.orderPaymentMethod = orderPaymentMethod;
	}
	

}

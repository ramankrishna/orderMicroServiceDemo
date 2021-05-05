package com.demo.ordermicroservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ordermicroservice.api.model.OrderDocument;
import com.demo.ordermicroservice.dao.BillingDAO;
import com.demo.ordermicroservice.dao.ItemDAO;
import com.demo.ordermicroservice.dao.OrderDAO;
import com.demo.ordermicroservice.dao.PaymentDAO;
import com.demo.ordermicroservice.dao.ShippingDAO;
import com.demo.ordermicroservice.db.model.Billing;
import com.demo.ordermicroservice.db.model.Item;
import com.demo.ordermicroservice.db.model.Order;
import com.demo.ordermicroservice.db.model.Payment;
import com.demo.ordermicroservice.db.model.Shipping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
public class OrderService {
	@Autowired
	public OrderDAO orderDAO;
	@Autowired
	public ItemDAO itemDAO;
	@Autowired
	public PaymentDAO paymentDAO;
	@Autowired
	public ShippingDAO shippingDAO;
	@Autowired
	public BillingDAO billingDAO;
	
	ObjectMapper mapper = new ObjectMapper();
	
	Logger log = LogManager.getLogger(OrderService.class);

	
	public int orderSaveToDb(Map<String, Object> orderFields) {
        log.debug("The values from Resource"+orderFields);
		Order order = orderDAO.save(populatingOrderValues(orderFields));
		log.atTrace();
		if(order!=null && order.getOrderId()!=0) {	
		Item item = populatingItemValues(orderFields, order.getOrderItemId(), order.getOrderId());
		log.debug(item);
		Shipping shipping = populatingShippingValues(orderFields, order.getOrderId(), order.getPaymentId());
        log.debug(shipping);
		Billing billing = populatingBillingValues(orderFields, order.getOrderId(), order.getPaymentId());
        log.debug(billing);
		Payment payment = populatingPaymentValues(orderFields, order.getPaymentId(), order.getOrderId(),
				"shipping_" + order.getOrderId(), "billing_" + order.getOrderId());
        log.debug(payment);
	    itemDAO.save(item);
		shippingDAO.save(shipping);
		billingDAO.save(billing);
	    paymentDAO.save(payment);
	    log.debug("the data is saved into the database!");
	    return order.getOrderId();
		}
		return 0;
	}

	public Order populatingOrderValues(Map<String, Object> orderFields) {

		Order order = new Order();
		return setOrderValuesfromMap(orderFields, order);
	}

	/**
	 * @param orderFields
	 * @param order
	 * @return
	 */
	private Order setOrderValuesfromMap(Map<String, Object> orderFields, Order order) {
		Date date = new Date();
		if (orderFields.containsKey("order_customer_id")) {
			order.setOrderCustomerId((int) orderFields.get("order_customer_id"));
		}
		if (orderFields.containsKey("order_status")) {
			order.setOrderStatus((String) orderFields.get("order_status"));
		}
		if (orderFields.containsKey("order_tax")) {
			order.setOrderTax((String) orderFields.get("order_tax"));
		}
		if (orderFields.containsKey("order_subtotal")) {
			order.setOrderTotal((String) orderFields.get("order_subtotal"));
		}
		order.setOrderItemId("item_" + order.getOrderCustomerId());
		order.setPaymentId("payment_" + order.getOrderCustomerId());
		order.setOrderCreateDate(date);
		order.setOrderModifiedDate(date);
		log.debug(order);
		return order;
	}

	public Item populatingItemValues(Map<String, Object> orderFields, String itemId, int orderId) {

		Item item = new Item();
		item.setItemID(itemId);
		item.setOrderId(orderId);
		if (orderFields.containsKey("order_item_name")) {
			item.setOrderItemName((String) orderFields.get("order_item_name"));
		}
		if (orderFields.containsKey("order_item_qty")) {
			item.setOrderItemQuantity((int) orderFields.get("order_item_qty"));
		}
		log.debug(item);
		return item;
	}

	public Shipping populatingShippingValues(Map<String, Object> orderFields, int orderId, String paymentId) {

		Shipping shipping = new Shipping();
		shipping.setPaymentId(paymentId);
		shipping.setShippingId("shipping_" + orderId);
		updateShipping(orderFields, shipping);
		log.debug(shipping);
		return shipping;
	}

	public Billing populatingBillingValues(Map<String, Object> orderFields, int orderId, String paymentId) {

		Billing billing = new Billing();
		billing.setPaymentId(paymentId);
		billing.setBillingId("billing_" + orderId);
		updateBilling(orderFields, billing);
		log.debug(billing);
		return billing;
	}

	public Payment populatingPaymentValues(Map<String, Object> orderFields, String paymentId, int orderId,
			String shippingId, String billingId) {
		Payment payment = new Payment();
		Date date = new Date();
		payment.setOrderId(orderId);
		payment.setPaymentId(paymentId);
		payment.setOrderConfirmationDate(date);
		payment.setOrderPaymentDate(date);
		if (orderFields.containsKey("order_customer_id")) {
			payment.setCustomerId((int) orderFields.get("order_customer_id"));
		}
		updatePayment(orderFields, payment);
		payment.setBillingId(billingId);
		payment.setShippingId(shippingId);
		log.debug(payment);
		return payment;
	}

	public Object getOrderFromDB(int orderId) {

		OrderDocument document = new OrderDocument();
		Optional<Order> orderData = orderDAO.findById(orderId);
		document.setOrder(orderData.get());
		ArrayList<Item> items = itemDAO.findAllByOrderId(document.getOrder().getOrderId());
		document.setItems(items);
		ArrayList<Payment> payments = paymentDAO.findAllByOrderId(document.getOrder().getOrderId());
		document.setPayments(payments);
		Shipping shippingData = shippingDAO.findById(document.getOrder().getPaymentId());
		document.setShipping(shippingData);
		Billing billingData = billingDAO.findById(document.getOrder().getPaymentId());
		document.setBilling(billingData);
		log.debug(document);
		return document;
	}

	public int deleteFromDB(int orderId) {

		if (orderDAO.existsById(orderId)) {
			orderDAO.deleteById(orderId);
			return orderId;
		}
		return -1;
	}

	
	public void insertLargeDataInDB(Object object) {

		@SuppressWarnings("unchecked")
		ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) mapper.convertValue(object,
				ArrayList.class);
		for (Map<String, Object> orderObject : data) {
			orderSaveToDb(orderObject);
		}
	}

	public void updateLargeOrderDataById(Object object) {
		@SuppressWarnings("unchecked")
		ArrayList<Map<String, Object>> data = (ArrayList<Map<String, Object>>) mapper.convertValue(object,
				ArrayList.class);
		Date date = new Date();
		for (Map<String, Object> orderObject : data) {
			setValuesForUpdate(date, orderObject);
		}
	}

	/**
	 * @param date
	 * @param orderObject
	 */
	private void setValuesForUpdate(Date date, Map<String, Object> orderObject) {
		Order order1 = updateOrder(date, orderObject);
		ArrayList<Item> itemList = itemDAO.findAllByOrderId(order1.getOrderId());
		for (Item item : itemList) {
			updateItem(orderObject, item);
		}
		Shipping shipping = shippingDAO.findById(order1.getPaymentId());
		updateShipping(orderObject, shipping);
		shippingDAO.save(shipping);
		Billing billing = billingDAO.findById(order1.getPaymentId());
		updateBilling(orderObject, billing);
		billingDAO.save(billing);
		ArrayList<Payment> paymentList = paymentDAO.findAllByOrderId(order1.getOrderId());
		for (Payment payment : paymentList) {
			updatePayment(orderObject, payment);
			paymentDAO.save(payment);
		}
	}

	/**
	 * @param orderObject
	 * @param payment
	 */
	private void updatePayment(Map<String, Object> orderObject, Payment payment) {
		if (orderObject.containsKey("order_payment_method")) {
			payment.setOrderPaymentMethod((String) orderObject.get("order_payment_method"));
		}
	}

	/**
	 * @param orderObject
	 * @param billing
	 */
	private void updateBilling(Map<String, Object> orderObject, Billing billing) {
		if (orderObject.containsKey("order_billing_addressline1")) {
			billing.setAddressLine1((String) orderObject.get("order_billing_addressline1"));
		}
		if (orderObject.containsKey("order_billing_addressline2")) {
			billing.setAddressLine2((String) orderObject.get("order_billing_addressline2"));
		}
		if (orderObject.containsKey("order_billing_city")) {
			billing.setCity((String) orderObject.get("order_billing_city"));
		}
		if (orderObject.containsKey("order_billing_state")) {
			billing.setState((String) orderObject.get("order_billing_state"));
		}
		if (orderObject.containsKey("order_shipping_zip")) {
			billing.setZip((String) orderObject.get("order_shipping_zip"));
		}
	}

	/**
	 * @param orderObject
	 * @param shipping
	 */
	private void updateShipping(Map<String, Object> orderObject, Shipping shipping) {
		if (orderObject.containsKey("order_shipping_addressline1")) {
			shipping.setAddressLine1((String) orderObject.get("order_shipping_addressline1"));
		}
		if (orderObject.containsKey("order_shipping_addressline2")) {
			shipping.setAddressLine2((String) orderObject.get("order_shipping_addressline2"));
		}
		if (orderObject.containsKey("order_shipping_city")) {
			shipping.setCity((String) orderObject.get("order_shipping_city"));
		}
		if (orderObject.containsKey("order_shipping_state")) {
			shipping.setState((String) orderObject.get("order_shipping_state"));
		}
		if (orderObject.containsKey("order_shipping_zip")) {
			shipping.setZip((String) orderObject.get("order_shipping_zip"));
		}
	}

	/**
	 * @param orderObject
	 * @param item
	 */
	private void updateItem(Map<String, Object> orderObject, Item item) {
		if (item.getItemID().equals(orderObject.get("itemID"))) {
			if (orderObject.containsKey("order_item_name")) {
				item.setOrderItemName((String) orderObject.get("order_item_name"));
			}
			if (orderObject.containsKey("order_item_qty")) {
				item.setOrderItemQuantity((int) orderObject.get("order_item_qty"));
			}
			itemDAO.save(item);
		}
	}

	/**
	 * @param date
	 * @param orderObject
	 * @return
	 */
	private Order updateOrder(Date date, Map<String, Object> orderObject) {
		int id = (int) orderObject.get("orderId");
		Optional<Order> order = orderDAO.findById(id);
		Order order1 = order.get();
		if (orderObject.containsKey("order_customer_id")) {
			order1.setOrderCustomerId((int) orderObject.get("order_customer_id"));
		}
		if (orderObject.containsKey("order_status")) {
			order1.setOrderStatus((String) orderObject.get("order_status"));
		}
		if (orderObject.containsKey("order_tax")) {
			order1.setOrderTax((String) orderObject.get("order_tax"));
		}
		if (orderObject.containsKey("order_subtotal")) {
			order1.setOrderTotal((String) orderObject.get("order_subtotal"));
		}
		order1.setOrderModifiedDate(date);
		orderDAO.save(order1);
		return order1;
	}
}

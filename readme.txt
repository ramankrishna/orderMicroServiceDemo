API ENDPOINTS :

POST : http://localhost:8080/orderms/batchOrders

[{
    "order_status": "Active",
    "order_customer_id": 222,
    "order_item_name": "cap",
    "order_item_qty": 12,
    "order_subtotal": "$200",
    "order_tax": "$3",
    "order_shipping_charges": "$22",
    "order_total": "$2625",
    "order_payment_method": "creditCard",
    "order_payment_date": "26-12-2020",
    "order_payment_confirmation_number": "1221",
    "order_billing_addressline1": "121 , Boyce avenue",
    "order_billing_addressline2": "122 , Texas",
    "order_billing_city": "Texas",
    "order_billing_state": "TA",
    "order_billing_zip": "200726",
    "order_shipping_addressline1": "121 , Boyce avenue",
    "order_shipping_addressline2": "122 , Texas",
    "order_shipping_city": "Texas",
    "order_shipping_state": "TA",
    "order_shipping_zip": "200726"
},
{
 "order_status": "Active",
    "order_customer_id": 201,
    "order_item_name": "bat",
    "order_item_qty": 3,
    "order_subtotal": "$200",
    "order_tax": "$3",
    "order_shipping_charges": "$22",
    "order_total": "$2625",
    "order_payment_method": "creditCard",
    "order_payment_date": "26-12-2020",
    "order_payment_confirmation_number": "1221",
    "order_billing_addressline1": "121 , Boyce avenue",
    "order_billing_addressline2": "122 , Texas",
    "order_billing_city": "Texas",
    "order_billing_state": "TA",
    "order_billing_zip": "200726",
    "order_shipping_addressline1": "121 , Boyce avenue",
    "order_shipping_addressline2": "122 , Texas",
    "order_shipping_city": "Texas",
    "order_shipping_state": "TA",
    "order_shipping_zip": "200726"
}]


POST http://localhost:8080/orderms/updateOrders

[{
    "orderId":1,
    "itemID": "item_222",
    "billingId": "billing_1",
    "shippingId": "shipping_1",
    "order_status": "InActive",
    "order_customer_id": 222,
    "order_item_name": "bottle",
    "order_item_qty": 12,
    "order_subtotal": "$200",
    "order_tax": "$3",
    "order_shipping_charges": "$22",
    "order_total": "$2625",
    "order_payment_method": "creditCard",
    "order_payment_date": "26-12-2020",
    "order_payment_confirmation_number": "1221",
    "order_billing_addressline1": "121 , Boyce avenue lol",
    "order_billing_addressline2": "122 , Texas lol",
    "order_billing_city": "Texas",
    "order_billing_state": "TA",
    "order_billing_zip": "200726",
    "order_shipping_addressline1": "121 , Boyce avenue lol",
    "order_shipping_addressline2": "122 , Texas lol",
    "order_shipping_city": "Texas",
    "order_shipping_state": "TA",
    "order_shipping_zip": "200726"
},
{
 "orderId":2,  
 "order_status": "InActive",
    "order_customer_id": 201,
    "itemID": "item_201",
    "order_item_name": "tap",
    "order_item_qty": 3,
    "order_subtotal": "$200",
    "order_tax": "$3",
    "order_shipping_charges": "$22",
    "order_total": "$2625",
    "order_payment_method": "debitcard",
    "order_payment_date": "26-12-2020",
    "order_payment_confirmation_number": "1221",
    "order_billing_addressline1": "121 , Boyce avenue lol",
    "order_billing_addressline2": "122 , Texas lol",
    "order_billing_city": "Texas",
    "order_billing_state": "TA",
    "order_billing_zip": "200726",
    "order_shipping_addressline1": "121 , Boyce avenue lol",
    "order_shipping_addressline2": "122 , Texas lol",
    "order_shipping_city": "Texas",
    "order_shipping_state": "TA",
    "order_shipping_zip": "200726"
}]

GET : http://localhost:8080/orderms/getOrderById/1

DELETE : http://localhost:8080/orderms/cancelOrder/1


package com.coforge.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coforge.model.Customer;
import com.coforge.model.DeliveryAddress;

@Configuration
public class BeanConfiguration {
	
	
	@Bean(name = "customer1")
	public Customer getCustomer() {
		Customer customer = new Customer(); //u can directly pass the values over here
	    customer.setCustomerId(112);
	    customer.setCustomerName("Suresh");
	    customer.setEmails(Arrays.asList("suresh1@gmail.com", "suresh2@gmail,com"));
	    customer.setDelivaryAddress(Arrays.asList(getDeliveryAddress1(), getDeliveryAddress2()));
	    return customer;
	}
	
	@Bean(name = "deliveryAddress1")
	public DeliveryAddress getDeliveryAddress1() {
		DeliveryAddress deliveryAddress1 = new DeliveryAddress();
		//you can pass the values in constructor or else use setter methods
		deliveryAddress1.setCity("Hyderabad");
		deliveryAddress1.setState("Telangana");
		return deliveryAddress1;
	}
	
	@Bean(name = "deliveryAddress2")
	public DeliveryAddress getDeliveryAddress2() {
		DeliveryAddress deliveryAddress1 = new DeliveryAddress();
		//you can pass the values in constructor or else use setter methods
		deliveryAddress1.setCity("Chennai");
		deliveryAddress1.setState("Tamil Nadu");
		return deliveryAddress1;
	}
}

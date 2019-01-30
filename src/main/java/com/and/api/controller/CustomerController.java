package com.and.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.and.api.model.Customer;
import com.and.api.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable("id") Integer id) {
		return custService.getCustomer(id);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return custService.getAllCustomers();
	}
	
	@RequestMapping(value="/customers",method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		custService.addCustomer(customer);
	}
	
	@RequestMapping(value="/customers/{id}",method=RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		custService.updateCustomer(id,customer);
	}

	@RequestMapping(value="/customers/{id}",method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable int id) {
		custService.deleteCustomer(id);
	}
}

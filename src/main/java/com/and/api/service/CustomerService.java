package com.and.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.and.api.model.Customer;
import com.and.api.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRep;
	
	public Customer getCustomer(Integer id) {
		return customerRep.findOne(id);
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customer = new ArrayList<>();
		customerRep.findAll().forEach(customer::add);
		return customer;	
	}
	
	public void addCustomer(Customer customer) {
		customerRep.save(customer);
	}

	public void updateCustomer(int id, Customer customer) {
		customerRep.save(customer);	
	}
	
	public void deleteCustomer(int id) {
		customerRep.delete(id);
		
	}

}

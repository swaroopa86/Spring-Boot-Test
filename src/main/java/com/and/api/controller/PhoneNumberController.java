package com.and.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.and.api.model.Customer;
import com.and.api.model.PhoneNumber;
import com.and.api.service.PhoneService;

@RestController
public class PhoneNumberController {

	@Autowired
	private PhoneService phoneService;
	
		
	@RequestMapping("/customers/{custId}/phonenumber")
	public List<PhoneNumber> getAllPhoneNumbers(@PathVariable int custId) {
		return phoneService.getAllPhoneNumbers(custId);
	}
	
	@RequestMapping("/phonenumber/{id}")
	public PhoneNumber getPhoneNumber(@PathVariable int id) {
		return phoneService.getPhoneNumber(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers/{custId}/phonenumber")
	public void addPhoneNumber(@RequestBody PhoneNumber phoneNo, @PathVariable int custId) {
		phoneNo.setCustomer(new Customer(custId,"",""));
		phoneService.addPhoneNumber(phoneNo);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{custId}/phonenumber/{id}")
	public void updatePhoneNumber(@RequestBody PhoneNumber phoneNo, @PathVariable int id,@PathVariable int custId) {
		phoneNo.setCustomer(new Customer(custId,"",""));
		phoneService.updatePhoneNumber(phoneNo);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/phonenumber/{id}")
	public void deletePhoneNumber(@PathVariable int id) {
		phoneService.deletePhoneNumber(id);
	}
}

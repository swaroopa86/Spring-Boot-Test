package com.and.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.and.api.model.PhoneNumber;
import com.and.api.repository.PhoneNumberRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneNumberRepository phonenoRep;
	
	public List<PhoneNumber> getAllPhoneNumbers(int custId) {
		List<PhoneNumber> phoneno = new ArrayList<>();
		phonenoRep.findByCustomerId(custId)
		.forEach(phoneno::add);
		return phoneno;
	}
	
	public PhoneNumber getPhoneNumber(int id) {
		return phonenoRep.findOne(id);
	}

	public void addPhoneNumber(PhoneNumber phoneNo) {
		phonenoRep.save(phoneNo);
	}

	public void updatePhoneNumber(PhoneNumber phoneNo) {
		phonenoRep.save(phoneNo);	
	}
	
	public void deletePhoneNumber(Integer id) {
		phonenoRep.delete(id);
		
	}
	
}

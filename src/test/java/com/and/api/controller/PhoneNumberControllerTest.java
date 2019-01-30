package com.and.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.and.api.AbstractTest;
import com.and.api.model.Customer;
import com.and.api.model.PhoneNumber;

public class PhoneNumberControllerTest extends AbstractTest {
	
	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Test
	   public void getPhoneNumber() throws Exception {
	      String uri = "/customers/3/phonenumber";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      PhoneNumber[] phoneno = super.mapFromJson(content, PhoneNumber[].class);
	      PhoneNumber phoneno1 = new PhoneNumber();
	      phoneno1.setCustomer(new Customer(3,"",""));
	      assertTrue(phoneno.length > 0);
	   }
	   
	   @Test
	   public void addPhoneNumber() throws Exception {
	      String uri = "/customers/3/phonenumber";
	      PhoneNumber phoneno = new PhoneNumber();
	      phoneno.setCustomer(new Customer(3,"",""));
	      phoneno.setPhoneno(958765478);
	      phoneno.setActivate("Yes");
	      String inputJson = super.mapToJson(phoneno);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Product is created successfully");
	   }
	   @Test
	   public void updateProduct() throws Exception {
	      String uri = "/customers/3/phonenumber/104";
	      PhoneNumber phoneno = new PhoneNumber();
	      phoneno.setCustomer(new Customer(3,"",""));
	      phoneno.setActivate("yes");
	      String inputJson = super.mapToJson(phoneno);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "PhoneNumber is updated successsfully");
	   }
	   
	   @Test
	   public void deleteProduct() throws Exception {
	      String uri = "/phonenumber/103";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "PhoneNumber is deleted successsfully");
	   }
	

}

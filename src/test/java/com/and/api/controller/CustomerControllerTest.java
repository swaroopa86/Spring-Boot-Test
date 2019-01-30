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

public class CustomerControllerTest extends AbstractTest {
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   @Test
	   public void getAllCustomers() throws Exception {
	      String uri = "/customers";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Customer[] customers = super.mapFromJson(content, Customer[].class);
	      assertTrue(customers.length > 0);
	   }
	   
	   @Test
	   public void addCustomer() throws Exception {
	      String uri = "/customers";
	      Customer customer = new Customer();
	      customer.setId(3);
	      customer.setName("Ginger");
	      customer.setEmail("uhd@uhh.net");
	      String inputJson = super.mapToJson(customer);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Customer is created successfully");
	   }
	   
	   @Test
	   public void updateCustomer() throws Exception {
	      String uri = "/customers/2";
	      Customer customer = new Customer();
	      customer.setName("Lemon");
	      String inputJson = super.mapToJson(customer);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Customer is updated successsfully");
	   }
	   
	   @Test
	   public void deleteCustomer() throws Exception {
	      String uri = "/customer/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Customer is deleted successsfully");
	   }
	

}

package com.and.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.and.api.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}

package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Customer;

import java.util.Optional;

public interface CustomerService {
	public Customer saveCustomer(Customer customer);

	boolean isExist(String customer_number);
	boolean isValid(Customer customer);


	public Optional<Customer> getCustomerById(String customer_number);

}

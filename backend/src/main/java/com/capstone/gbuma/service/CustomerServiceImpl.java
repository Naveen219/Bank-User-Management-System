package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Customer;
import com.capstone.gbuma.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(String customer_number) {
		System.out.println("from repo"+customerRepo.findById(customer_number));
		return customerRepo.findById(customer_number);
	}

	@Override
	public boolean isValid(Customer customer) {
		return customerRepo.findByCustomerNumber(customer.getCustomer_number(), customer.getPassword()).size() == 1;
	}

	@Override
	public boolean isExist(String customer_number) {
		System.out.println("returned " + customer_number + " " + customerRepo.findById(customer_number));
		return customerRepo.findById(customer_number).isPresent();
	}
}

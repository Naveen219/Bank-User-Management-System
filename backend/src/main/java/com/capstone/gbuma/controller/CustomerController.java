package com.capstone.gbuma.controller;

import com.capstone.gbuma.entity.Customer;
import com.capstone.gbuma.service.AccountService;
import com.capstone.gbuma.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {
		System.out.println(customer);
		if (customerService.isExist(customer.getCustomerId())) {
			System.out.println("Exist" + customer);
			return null;
		} else {
			System.out.println("Not Exist" + customer);
			return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.OK);
		}
	}

	@GetMapping("/accountExist")
	public ResponseEntity<Boolean> getAccountHolders(@RequestParam String customer_number) {
		return new ResponseEntity<Boolean>(accountService.getAccounts(customer_number), HttpStatus.OK);

	}

//	@PostMapping("/login")
//	public ResponseEntity<Boolean> isValid(@RequestBody Customer customer) {
//
//		return new ResponseEntity<Boolean>(customerService.isValid(customer), HttpStatus.OK);
//
//	}

}

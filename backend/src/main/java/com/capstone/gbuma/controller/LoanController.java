package com.capstone.gbuma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.gbuma.entity.Customer;
import com.capstone.gbuma.entity.Loan;
import com.capstone.gbuma.service.LoanService;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins="http://localhost:3000")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	@PostMapping("/addloan")
	public ResponseEntity<?> addloan(@RequestBody Loan loan) {
		System.out.println(loan);
		return new ResponseEntity<Loan>(loanService.saveLoanDetails(loan), HttpStatus.OK);
	}
}

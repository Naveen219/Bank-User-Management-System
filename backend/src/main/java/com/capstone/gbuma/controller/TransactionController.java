package com.capstone.gbuma.controller;

import java.util.Date;
import java.util.List;

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
import com.capstone.gbuma.entity.Transaction;
import com.capstone.gbuma.service.TransactionService;;

@RestController
@RequestMapping("/api/transaction")
@CrossOrigin(origins="http://localhost:3000")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	@PostMapping("/addtransaction")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
		return new ResponseEntity<Transaction>(transactionService.addTransaction(transaction),HttpStatus.OK);
		
	}
	
	@GetMapping("/viewTransactions")
	public ResponseEntity<List<Transaction>> viewTransactions(@RequestParam String account_number,@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String transaction_type){
		System.out.println(fromDate+" +"+ toDate);
		return new ResponseEntity<List<Transaction>>(transactionService.viewTransaction(account_number, fromDate, toDate,transaction_type),HttpStatus.OK);
		
	}
}

package com.capstone.gbuma.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.gbuma.entity.Transaction;
import com.capstone.gbuma.repo.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		System.out.println(transaction.getAccount_number());
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> viewTransaction(String account_number, String fromDate, String toDate,String transaction_type) {
//		System.out.println(transactionRepo.getAllTransactionsByPeriod(account_number, Date.valueOf(fromDate), Date.valueOf(toDate)));
		return transactionRepo.getAllTransactionsByPeriod(account_number, Date.valueOf(fromDate), Date.valueOf(toDate),transaction_type);
	}

}

package com.capstone.gbuma.service;
import java.util.List;

import com.capstone.gbuma.entity.Transaction;
public interface TransactionService {
	public Transaction addTransaction(Transaction transaction);
	public List<Transaction> viewTransaction(String account_number,String fromDate,String toDate,String transaction_type);
}

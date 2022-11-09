package com.capstone.gbuma.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.gbuma.entity.Account;
import com.capstone.gbuma.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	@Override
	public List<Account> getAccounts(String customer_number) {
		return accountRepo.findByCustomerNumber(customer_number);
	}
	
	

}

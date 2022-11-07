package com.capstone.gbuma.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.gbuma.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	@Override
	public Boolean getAccounts(String customer_number) {
		if(accountRepo.findByCustomerNumber(customer_number).size()==0) {
			return false;
		}
		return true;
	}

}

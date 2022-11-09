package com.capstone.gbuma.service;
import java.util.List;

import com.capstone.gbuma.entity.Account;
public interface AccountService {
	public List<Account> getAccounts(String customer_number);

}

package com.capstone.gbuma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.gbuma.entity.Loan;
import com.capstone.gbuma.repo.LoanRepo;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepo loanRepo;

	@Override
	public Loan saveLoanDetails(Loan loan) {
		return loanRepo.save(loan);
	}

}

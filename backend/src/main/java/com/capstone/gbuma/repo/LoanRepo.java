package com.capstone.gbuma.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.gbuma.entity.Customer;
import com.capstone.gbuma.entity.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, String> {

}

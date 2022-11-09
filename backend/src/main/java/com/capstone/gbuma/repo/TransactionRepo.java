package com.capstone.gbuma.repo;

import java.util.List;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.gbuma.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String>{
	
	@Query(value="select * from transaction_details where account_number=?1 and date_of_transaction between ?2 and ?3 and transaction_type=?4",nativeQuery = true)
	public List<Transaction> getAllTransactionsByPeriod(String account_number,Date fromDate,Date toDate,String transaction_type);
	
}

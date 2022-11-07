package com.capstone.gbuma.repo;
import com.capstone.gbuma.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account,String>{

	@Query(value = "SELECT * FROM account_master WHERE customer_number = ?1", nativeQuery = true)
	  List<Account> findByCustomerNumber(String customer_number);
}

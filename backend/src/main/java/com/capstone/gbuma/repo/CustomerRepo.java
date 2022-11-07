package com.capstone.gbuma.repo;

import com.capstone.gbuma.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
	@Query(value = "SELECT * FROM customer_master WHERE customer_number = ?1 and password=?2", nativeQuery = true)
	List<Customer> findByCustomerNumber(String customer_number, String password);
}

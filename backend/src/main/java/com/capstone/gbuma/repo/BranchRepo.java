package com.capstone.gbuma.repo;

import com.capstone.gbuma.entity.Branch;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, String> {
	@Query(value = "select * from branch_master b where b.branch_id in (select a.branch_id from account_master a where a.customer_number=?1)", nativeQuery = true)
	List<Branch> findBranches(String customer_number);
}

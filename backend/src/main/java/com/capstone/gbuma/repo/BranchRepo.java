package com.capstone.gbuma.repo;

import com.capstone.gbuma.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch, String> {
}

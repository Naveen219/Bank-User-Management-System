package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Branch;
import com.capstone.gbuma.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepo branchRepo;
    @Override
	public List<Branch> getBranches(String customer_number) {

		return branchRepo.findBranches(customer_number);
	}
}
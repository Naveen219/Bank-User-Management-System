package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Branch;

import java.util.List;

public interface BranchService {
	public List<Branch> getBranches(String customer_number);
}

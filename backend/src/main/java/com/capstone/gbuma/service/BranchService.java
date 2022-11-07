package com.capstone.gbuma.service;

import com.capstone.gbuma.entity.Branch;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BranchService {
    public List<Branch> getAllBranches();

    public Branch getBranchById(String branchId);
}

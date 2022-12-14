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
    public List<Branch> getAllBranches() {
        return branchRepo.findAll();
    }
    public Branch getBranchById(String branchId) {
        return branchRepo.findByBranchId(branchId);
    }
}
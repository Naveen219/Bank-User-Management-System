package com.capstone.gbuma.controller;

import com.capstone.gbuma.entity.Branch;
import com.capstone.gbuma.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/getAllBranches")
    public List<Branch> getAllBranches() {
        return branchService.getAllBranches();
    }
}

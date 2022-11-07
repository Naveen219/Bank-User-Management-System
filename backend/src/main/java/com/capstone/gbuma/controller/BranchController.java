package com.capstone.gbuma.controller;

import com.capstone.gbuma.entity.Branch;
import com.capstone.gbuma.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
@CrossOrigin(origins="http://localhost:3000")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/getBranches")
	public ResponseEntity<List<Branch>> getBranches(@RequestParam String customer_number) {
		System.out.println("Customer" + customer_number);
		return new ResponseEntity<List<Branch>>(branchService.getBranches(customer_number), HttpStatus.OK);
	}
}
																																																																																																																																																																																																
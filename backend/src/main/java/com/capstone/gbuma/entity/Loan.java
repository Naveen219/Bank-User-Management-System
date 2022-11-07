package com.capstone.gbuma.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "loan_details")
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
	@Id
	private String branch_id;
	private String customer_number;
	private int loan_amount;
//	@ManyToOne
//	private Branch branch;

}

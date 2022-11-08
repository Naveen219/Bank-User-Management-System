package com.capstone.gbuma.entity;

import javax.persistence.EmbeddedId;
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
	@EmbeddedId
	private MyKey myKey;
	private int loan_amount;
//	@ManyToOne
//	private Branch branch;
	public MyKey getMyKey() {
		return myKey;
	}
	public void setMyKey(MyKey myKey) {
		this.myKey = myKey;
	}
	public int getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(int loan_amount) {
		this.loan_amount = loan_amount;
	}
	@Override
	public String toString() {
		return "Loan [myKey=" + myKey + ", loan_amount=" + loan_amount + "]";
	}
	public Loan(MyKey myKey, int loan_amount) {
		super();
		this.myKey = myKey;
		this.loan_amount = loan_amount;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

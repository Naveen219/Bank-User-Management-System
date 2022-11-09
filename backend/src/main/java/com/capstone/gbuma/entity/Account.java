package com.capstone.gbuma.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "account_master")

public class Account {
	@Id
	private String account_number;
	private String customer_number;
	private String branch_id;
	private Integer opening_balance;
	private Date account_opening_date;
	private String account_type;
	private String account_status;

	

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public Integer getOpening_balance() {
		return opening_balance;
	}

	public void setOpening_balance(Integer opening_balance) {
		this.opening_balance = opening_balance;
	}

	public Date getAccount_opening_date() {
		return account_opening_date;
	}

	public void setAccount_opening_date(Date account_opening_date) {
		this.account_opening_date = account_opening_date;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String account_number, String customer_number, String branch_id, Integer opening_balance,
			Date account_opening_date, String account_type, String account_status, Customer customer, Branch branch,
			List<Transaction> transactionList) {
		super();
		this.account_number = account_number;
		this.customer_number = customer_number;
		this.branch_id = branch_id;
		this.opening_balance = opening_balance;
		this.account_opening_date = account_opening_date;
		this.account_type = account_type;
		this.account_status = account_status;
		this.customer = customer;
		this.branch = branch;
		this.transactionList = transactionList;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", customer_number=" + customer_number + ", branch_id="
				+ branch_id + ", opening_balance=" + opening_balance + ", account_opening_date=" + account_opening_date
				+ ", account_type=" + account_type + ", account_status=" + account_status + ", customer=" + customer
				+ ", branch=" + branch + "]";
	}
	
	@ManyToOne
	@JoinColumn(name = "customer_number",updatable=false,insertable=false)
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "branch_id",updatable=false,insertable=false)
	private Branch branch;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactionList;
}
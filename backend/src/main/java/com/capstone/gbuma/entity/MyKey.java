package com.capstone.gbuma.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MyKey implements Serializable {
	@Column(name="branch_id")
	private String branch_id;
	@Column(name="customer_number")
	private String customer_number;
	public String getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
	public String getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
	public MyKey(String branch_id, String customer_number) {
		super();
		this.branch_id = branch_id;
		this.customer_number = customer_number;
	}
	public MyKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

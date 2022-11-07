package com.capstone.gbuma.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name="account_master")

public class Account {
	@Id
	private String account_number;
	private String customer_number;
	private String branch_id;
	private Integer opening_balance;
	private Date account_opening_date;
	private String account_type;
	private String account_status;
	
	
	
	
}
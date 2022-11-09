package com.capstone.gbuma.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction_details")
public class Transaction {
	@Id
	@Column(name = "transaction_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_number;

	private String account_number;

	@Column(name = "date_of_transaction")
	private Date date_of_transaction;

	@Column(name = "medium_of_transaction")
	private String medium_of_transaction;

	@Column(name = "transaction_type")
	private String transaction_type;

	@Column(name = "transaction_amount")
	private int transaction_amount;

	public int getTransaction_number() {
		return transaction_number;
	}

	public void setTransaction_number(int transaction_number) {
		this.transaction_number = transaction_number;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Date getDate_of_transaction() {
		return date_of_transaction;
	}

	public void setDate_of_transaction(Date date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}

	public String getMedium_of_transaction() {
		return medium_of_transaction;
	}

	public void setMedium_of_transaction(String medium_of_transaction) {
		this.medium_of_transaction = medium_of_transaction;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public int getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transaction(int transaction_number, String account_number, Date date_of_transaction,
			String medium_of_transaction, String transaction_type, int transaction_amount, Account account) {
		super();
		this.transaction_number = transaction_number;
		this.account_number = account_number;
		this.date_of_transaction = date_of_transaction;
		this.medium_of_transaction = medium_of_transaction;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.account = account;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@Override
//	public String toString() {
//		return "Transaction [transaction_number=" + transaction_number + ", account_number=" + account_number
//				+ ", date_of_transaction=" + date_of_transaction + ", medium_of_transaction=" + medium_of_transaction
//				+ ", transaction_type=" + transaction_type + ", transaction_amount=" + transaction_amount + ", account="
//				+ account + "]";
//	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_number", updatable = false, insertable = false)
	private Account account;
}

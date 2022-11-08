package com.capstone.gbuma.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_master")
public class Customer {
    @Id
    @Column(name = "customer_number")
    private String customer_number;

    @Column(name = "password")
    private String password;

    @Column(name ="firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "customer_city")
    private String customer_city;

    @Column(name = "customer_contact_no")
    private String customer_contact_no;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "customer_date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    private Date customer_date_of_birth;

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}

	public String getCustomer_contact_no() {
		return customer_contact_no;
	}

	public void setCustomer_contact_no(String customer_contact_no) {
		this.customer_contact_no = customer_contact_no;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getCustomer_date_of_birth() {
		return customer_date_of_birth;
	}

	public void setCustomer_date_of_birth(Date customer_date_of_birth) {
		this.customer_date_of_birth = customer_date_of_birth;
	}

	public Customer(String customer_number, String password, String firstname, String middlename, String lastname,
			String customer_city, String customer_contact_no, String occupation, Date customer_date_of_birth) {
		super();
		this.customer_number = customer_number;
		this.password = password;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.customer_city = customer_city;
		this.customer_contact_no = customer_contact_no;
		this.occupation = occupation;
		this.customer_date_of_birth = customer_date_of_birth;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customer_number=" + customer_number + ", password=" + password + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", customer_city=" + customer_city
				+ ", customer_contact_no=" + customer_contact_no + ", occupation=" + occupation
				+ ", customer_date_of_birth=" + customer_date_of_birth + "]";
	}

}

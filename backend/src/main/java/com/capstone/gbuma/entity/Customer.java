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
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "customer_city")
    private String customerCity;

    @Column(name = "customer_contact_no")
    private String contactNumber;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "customer_date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    private Date dob;

    public String getCustomerId() {
		return customer_number;
	}

	public void setCustomerId(String customerId) {
		this.customer_number = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Customer(String customerId, String password, String firstName, String middleName, String lastName,
			String customerCity, String contactNumber, String occupation, Date dob) {
		super();
		this.customer_number = customerId;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.customerCity = customerCity;
		this.contactNumber = contactNumber;
		this.occupation = occupation;
		this.dob = dob;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customer_number + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", occupation='" + occupation + '\'' +
                ", dob=" + dob +
                '}';
    }
}

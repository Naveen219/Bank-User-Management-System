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
    private String customerId;

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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
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

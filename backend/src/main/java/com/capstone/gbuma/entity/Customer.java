package com.capstone.gbuma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_master")
public class Customer {
    @Id
    @Column("customer_number")
    private String customer_no;

    @Column("password")
    private String password;

    @Column("firstname")
    private String firstName;

    @Column("middlename")
    private String middleName;

    @Column("lastname")
    private String lastName;

    @Column("")
    private String 

}

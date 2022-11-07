package com.capstone.gbuma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "opening_balance")
    private int balance;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_status")
    private String accountStatus;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private  Customer customer;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactionList;
}

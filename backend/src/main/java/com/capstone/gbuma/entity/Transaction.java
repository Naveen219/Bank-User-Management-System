package com.capstone.gbuma.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @Column(name = "transaction_number")
    private String transactionId;

    @Column(name = "date_of_transaction")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
    private Date dateOfTransaction;

    @Column(name = "medium_of_transaction")
    private String mediumOfTransaction;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_amount")
    private String transactionAmount;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;
}

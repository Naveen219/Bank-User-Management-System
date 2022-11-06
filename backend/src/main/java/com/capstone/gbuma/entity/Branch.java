package com.capstone.gbuma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    @Id
    @Column(name = "branch_id")
    private String branchId;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "branch_city")
    private String branchCity;
}


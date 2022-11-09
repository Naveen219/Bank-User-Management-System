package com.capstone.gbuma.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	@OneToMany(mappedBy = "branch")
    private List<Account> accountList;
}


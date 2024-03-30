package com.cts.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingReport {
	@Id
	private Long associateId;
	
	private String associateName;
	
	private Long projectId;
	
	private String projectDesciption;
	
	private String projectBillability;
	
	private Long projectManagerId;
	
	private String projectManagerName;
	
	private Long accountId;
	
	private String accountName;
	
	private String grade;
	
	private String departmentName;
	
	private String billabilityStatus;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private Date assignmentStartDate;
	
	private Date assignmentEndDate;
	
	private String assignmentStatus;
	
	private Long percentAllocation;

}

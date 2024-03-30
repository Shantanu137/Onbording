package com.cts.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "screen")
public class Screen {

	@Id
	private int associate_id;
	private String associate_name;
	private String project_description;
	private String project_manager_name;
	private String grade;
	private String department;
	private String skill_category;
	private String poc;
	private String location;
	private String comment;
	private Date esa_start_date;
	private Date billing_start_date;
	private Boolean billable;

	// Getter - Setter method
	public int getAssociate_id() {
		return associate_id;
	}

	public void setAssociate_id(int associate_id) {
		this.associate_id = associate_id;
	}

	public String getAssociate_name() {
		return associate_name;
	}

	public void setAssociate_name(String associate_name) {
		this.associate_name = associate_name;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public String getProject_manager_name() {
		return project_manager_name;
	}

	public void setProject_manager_name(String project_manager_name) {
		this.project_manager_name = project_manager_name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSkill_category() {
		return skill_category;
	}

	public void setSkill_category(String skill_category) {
		this.skill_category = skill_category;
	}

	public String getPoc() {
		return poc;
	}

	public void setPoc(String poc) {
		this.poc = poc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getEsa_start_date() {
		return esa_start_date;
	}

	public void setEsa_start_date(Date esa_start_date) {
		this.esa_start_date = esa_start_date;
	}

	public Date getBilling_start_date() {
		return billing_start_date;
	}

	public void setBilling_start_date(Date billing_start_date) {
		this.billing_start_date = billing_start_date;
	}

	public Boolean getBillable() {
		return billable;
	}

	public void setBillable(Boolean billable) {
		this.billable = billable;
	}

}

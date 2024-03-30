package com.cts.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

	private String firstName;
	private String lastName;
	@Id
	private long id;
	private String phoneNumber;
	private String username;
	private String emailId;
	private String password;
	private String role = "student";
	private boolean enabled = true;

}

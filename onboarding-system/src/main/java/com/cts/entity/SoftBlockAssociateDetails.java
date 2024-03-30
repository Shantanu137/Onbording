package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SBAssDetails")
public class SoftBlockAssociateDetails {

	@Column(name = "so_id")
	private Long soId;

	@Id
	@Column(name = "associate_id")
	private Long associateId;

	@Column(name = "associate_name")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "{associateName.pattern}")
	private String associateName;

	@Column(name = "status")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "{status.pattern}")
	private String status;

	@Column(name = "feedback")
	@Pattern(regexp = "^[a-z A-Z0-9]*$", message = "{feedback.pattern}")
	private String feedback;

}

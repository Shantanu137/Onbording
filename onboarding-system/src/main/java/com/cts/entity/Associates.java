package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Associates {

	private String poc;

	private String programName;

	private long winZoneId;

	private String beelineReqId;

	@Pattern(regexp = "^[a-z A-Z]*$", message = "{newRampUpOrReplacement.pattern}")
	private String newRampUpOrReplacement;

	@Id
	private Long soId;

	@Pattern(regexp = "^[a-z A-Z]*$", message = "{grade.pattern}")
	private String grade;

	@Pattern(regexp = "^[a-z A-Z]*$", message = "{soStatus.pattern}")
	private String soStatus;

	private Boolean isCritical;

	private Boolean peSo;

	@NotBlank(message = "{location.notBlank}")
	private String location;

	@Pattern(regexp = "^[a-z A-Z0-9]*$", message = "{primarySkills.pattern}")
	private String primarySkills;

	private String secndarySkills;

	@Pattern(regexp = "^[0-9]*$", message = "{projectId.pattern}")
	private String projectId;

	@Pattern(regexp = "^[a-z A-Z0-9]*$", message = "{projectName.pattern}")
	private String projectName;

	private String esaPm;

	private String comments;

}
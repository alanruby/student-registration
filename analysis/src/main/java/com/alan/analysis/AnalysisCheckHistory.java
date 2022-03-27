package com.alan.analysis;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnalysisCheckHistory {
	
	@Id
	@SequenceGenerator(
			name = "analysis_id_sequence",
			sequenceName= "analysis_id_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "analysis_id_sequence"
	)
	private Integer id;
	private Integer studentId;
	private Boolean isFraud;
	private LocalDateTime createdAt;

}

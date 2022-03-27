package com.alan.analysis;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AnalysisCheckService {
	
	private final AnalysisCheckHistoryRepository analysisCheckHistoryRepository;
	
	public boolean isFraudulentStudent(Integer studentId) {
		analysisCheckHistoryRepository.save(
				AnalysisCheckHistory.builder()
				.studentId(studentId)
				.isFraud(false)
				.createdAt(LocalDateTime.now())
				.build()
		);
		return false;
	}
}

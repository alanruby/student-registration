package com.alan.analysis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alan.clientsapp.analysis.AnalysisCheckResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("api/v1/analysis")
@AllArgsConstructor
@Slf4j
public class AnalysisController {
	
	private final AnalysisCheckService analysisCheckService;
	
	@GetMapping(path="{studentId}")
	public AnalysisCheckResponse isFraud(
			@PathVariable("studentId") Integer studentId) {
			boolean isfraudulentStudent = analysisCheckService.isFraudulentStudent(studentId);
			log.info("## analysis check request for customer {}", studentId);
			return new AnalysisCheckResponse(isfraudulentStudent);
	}
}

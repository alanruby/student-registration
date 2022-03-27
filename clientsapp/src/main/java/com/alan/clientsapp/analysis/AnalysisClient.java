package com.alan.clientsapp.analysis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("analysis")
public interface AnalysisClient {
	@GetMapping(path="api/v1/analysis/{studentId}")
	public AnalysisCheckResponse isFraud(
			@PathVariable("studentId") Integer studentId);

}
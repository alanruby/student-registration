package com.alan.student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
	
	private final StudentService studentService;
	
	@PostMapping
	public void registerStudent(@RequestBody StudentRegistrationRequest studentRequest) {
		log.info("## new student registration {}",studentRequest);
		studentService.registerStudent(studentRequest);
	}

}

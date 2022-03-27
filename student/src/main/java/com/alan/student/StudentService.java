package com.alan.student;

import org.springframework.stereotype.Service;

import com.alan.amqpapp.RabbitMQMessageProducer;
import com.alan.clientsapp.analysis.AnalysisCheckResponse;
import com.alan.clientsapp.analysis.AnalysisClient;
import com.alan.clientsapp.notification.NotificationClient;
import com.alan.clientsapp.notification.NotificationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	private final AnalysisClient  analysisClient;
	private final RabbitMQMessageProducer rabbitMQMessageProducer;

	public void registerStudent(StudentRegistrationRequest studentRequest) {
		Student student = Student.builder().firstName(studentRequest.firstName()).lastName(studentRequest.lastName())
				.email(studentRequest.email()).build();
		studentRepository.saveAndFlush(student);

		
		 AnalysisCheckResponse analysisCheckResponse = analysisClient.isFraud(student.getId());
		 
		 if (analysisCheckResponse.isFraud()) {
			 throw new IllegalStateException("## Fraud!");
		 }
		 
		 NotificationRequest notificationRequest = new NotificationRequest(student.getId(),
		 student.getEmail(),
		 String.format("Hi %s, welcome to the library", student.getFirstName()));
		 
		 rabbitMQMessageProducer.publish(notificationRequest,"internal.exchange","internal.notification.routing-key");
		 
		 

	}

}
    
# student-registration

Student registration Project

Some microservices were built to simulate the process of student registration using containers and
messaging service. The focus of this project is architecture and therefore this a is very simple app, not realistic
or really functional.

Application Spring Boot.

Funcionalities
- Register

Some Features
- Api with Spring MVC
- Rabbitmq
- Docker, Jib, eclipse-temurin 
- JPA
- Openfeign 
- Eureka
- Sleuth and Zipkin
- Gateway

## Notes:

Microservices
  - Student: after posting the credentials (firstName, lastName, email) to localhost/api/v1/student the data is analyzed and a
  notification is send to the internal rabbit queue.
  - NotificationApp: Consumes the notification and persists it in the database.
  - Analysis: verifies if the message from the Student is a fraud.
  - Apigwy: gateway

Modules
  - clientsapp: reusable apis. Exposes REST clients for analysis and notification.
  - amqpapp: rabbit settings.

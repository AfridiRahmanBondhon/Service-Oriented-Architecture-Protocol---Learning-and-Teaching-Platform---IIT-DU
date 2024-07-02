# Learning and Teaching Platform SOAP Services

This project is a comprehensive SOAP-based platform 
designed to facilitate learning and teaching activities.
The functionality is similar to Udemy or Coursera.

It encompasses a range of services that handle various
aspects of the platform. Each service is independent 
and ensures loose coupling. The service contract is 
implemented through WSDL. As the services are 
independent, they inherit the statelessness property. 
Moreover, the few dependencies on the database 
entities in this project point towards loose coupling.

## Services Overview

### Student
- **Description:** Manages student-related operations such
  as student registration, updating student information, and
  retrieving student details. It is an Entity Service.


### Teacher
- **Description:** Manages teacher-related operations
  including adding, updating, and retrieving teacher
  information. It is an Entity Service.

### ContentUploadService
- **Description:** Manages content upload operations, 
allowing users to upload and manage various types of 
content. The content upload service is for the tutor to upload lecture videos and slides. This is a Task Service.

### Library
- **Description:** Library Service shows all the contents to 
both type of users (Student and Teachers). 
It provides library services including adding, retrieving,
and managing library resources. It is a Task Service that 
intracts with the ContentUploadService.

### Login
- **Description:** Provides authentication and authorization 
services for users. The Login service is used to login and signup
both type of users (Students and Teachers). It is a Utility Service.


### MakePayment
- **Description:** Manages payment processing and transactions 
within the platform. The payment service is for the 
students to pay their fees. It is also a Utility Service.


### Notification
- **Description:** To notify about tasks, the notification 
service is implemented. It handles notification services 
including sending and managing notifications for various 
events. It is also a Utility Service.

### Quiz
- **Description:** Handles quiz-related operations such as 
creating quizzes, managing quiz questions, and retrieving 
quiz results. It is an Entity Service.


### Tutorial
- **Description:** This service is at it is. 
It was pre-implemented in sir's given project. 
I just seperated the XSD and imported in WSDL.


### Webinar
- **Description:** Handles webinar operations including 
creating, managing, and registering for webinars. It is an Entity Service.


## Key Principles

- **Independence and Loose Coupling:** Every service is independent and ensures loose coupling. The few dependencies on the database entities further enhance this characteristic.
- **Service Contracts:** The service contract is implemented through WSDL, ensuring clear definitions and interfaces for each service.
- **Statelessness:** As the services are independent, they inherit the statelessness property, improving scalability and reliability.

## Accessibility
**After running the application, you can access the WSDL files for each service using the following URLs:**
- Content Upload Service: `http://localhost:8080/ws/contentuploadservice.wsdl`
- Library Service: `http://localhost:8080/ws/library.wsdl`
- Login Service: `http://localhost:8080/ws/login.wsdl`
- Make Payment Service: `http://localhost:8080/ws/makepayment.wsdl`
- Notification Service: `http://localhost:8080/ws/notification.wsdl`
- Quiz Service: `http://localhost:8080/ws/quiz.wsdl`
- Student Service: `http://localhost:8080/ws/student.wsdl`
- Teacher Service: `http://localhost:8080/ws/teacher.wsdl`
- Tutorial Service: `http://localhost:8080/ws/tutorial.wsdl`
- Webinar Service: `http://localhost:8080/ws/webinar.wsdl`

## Getting Started

### Prerequisites

- Java 8
- JDK 1.8.0
- Maven
- IntelliJ

### Running the Services

1. Clone the repository:
   ```bash
    git remote add origin https://github.com/AfridiRahmanBondhon/Service-Oriented-Architecture-Protocol---Learning-and-Teaching-Platform---IIT-DU.git
    cd learning-and-teaching-platform-SOAP
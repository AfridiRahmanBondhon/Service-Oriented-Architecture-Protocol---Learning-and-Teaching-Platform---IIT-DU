package com.wsstudent.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wsstudent.ws.studentservice.*;
//import com.wsstudent.ws.student.GetStudentResponse;
//import com.wsstudent.ws.student.AddStudentRequest;
//import com.wsstudent.ws.student.AddStudentResponse;
//import com.wsstudent.ws.student.DeleteStudentRequest;
//import com.wsstudent.ws.student.DeleteStudentResponse;

@Endpoint
public class StudentEndpoint {

    private static final String NAMESPACE_URI = "http://www.wsstudent.com/ws/StudentService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        // Simulated data retrieval
        //response.setStudent(createMockStudent(request.getStudentId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
        AddStudentResponse response = new AddStudentResponse();
        // Simulated data addition
        response.setStatus("Student added successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudent(@RequestPayload DeleteStudentRequest request) {
        DeleteStudentResponse response = new DeleteStudentResponse();
        // Simulated data deletion
        response.setStatus("Student deleted successfully");
        return response;
    }

    // Simulated method to create a mock student
//    private Student createMockStudent(int studentId) {
//        Student student = new Student();
//        student.setStudentId(studentId);
//        student.setName("John Doe");
//        student.setAge(20);
//        student.setEmail("john.doe@example.com");
//        return student;
//    }
}

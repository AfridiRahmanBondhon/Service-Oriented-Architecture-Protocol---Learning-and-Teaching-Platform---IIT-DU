package com.wsteacher.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.wsteacher.ws.teacherservice.*;

@Endpoint
public class TeacherServiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.wsteacher.com/ws/TeacherService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddTeacherRequest")
    @ResponsePayload
    public AddTeacherResponse addTeacher(@RequestPayload AddTeacherRequest request) {
        ObjectFactory factory = new ObjectFactory();
        AddTeacherResponse response = factory.createAddTeacherResponse();
        StatusResponse status = factory.createStatusResponse();

        // Add teacher logic here

        status.setCode(201);
        status.setMessage("Teacher added successfully");
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateTeacherRequest")
    @ResponsePayload
    public UpdateTeacherResponse updateTeacher(@RequestPayload UpdateTeacherRequest request) {
        ObjectFactory factory = new ObjectFactory();
        UpdateTeacherResponse response = factory.createUpdateTeacherResponse();
        StatusResponse status = factory.createStatusResponse();

        // Update teacher logic here

        status.setCode(200);
        status.setMessage("Teacher updated successfully");
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTeacherRequest")
    @ResponsePayload
    public GetTeacherResponse getTeacher(@RequestPayload GetTeacherRequest request) {
        ObjectFactory factory = new ObjectFactory();
        GetTeacherResponse response = factory.createGetTeacherResponse();

        // Get teacher logic here

        Teacher teacher = factory.createTeacher();
        teacher.setTeacherId(request.getTeacherId());
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        teacher.setEmail("john.doe@example.com");
        teacher.setSubject("Mathematics");

        response.setTeacher(teacher);
        return response;
    }
}


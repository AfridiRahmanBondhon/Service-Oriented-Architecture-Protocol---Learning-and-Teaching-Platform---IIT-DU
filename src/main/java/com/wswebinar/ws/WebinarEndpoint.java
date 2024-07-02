package com.wswebinar.ws;

import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wswebinar.ws.webinar.*;
//import wswebinar.ws.webinar.CreateWebinarResponse;
//import wswebinar.ws.webinar.GetWebinarDetailsRequest;
//import wswebinar.ws.webinar.GetWebinarDetailsResponse;
//import wswebinar.ws.webinar.RegisterParticipantRequest;
//import wswebinar.ws.webinar.RegisterParticipantResponse;

@Endpoint
public class WebinarEndpoint {

    private static final String NAMESPACE_URI = "http://www.wswebinar.com/ws/webinar";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateWebinarRequest")
    @ResponsePayload
    public CreateWebinarResponse createWebinar(@RequestPayload CreateWebinarRequest request) {
        CreateWebinarResponse response = new CreateWebinarResponse();
        response.setWebinarId(1); // Sample ID
        response.setStatus("SUCCESS");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetWebinarDetailsRequest")
    @ResponsePayload
    public GetWebinarDetailsResponse getWebinarDetails(@RequestPayload GetWebinarDetailsRequest request) {
        GetWebinarDetailsResponse response = new GetWebinarDetailsResponse();
        response.setTitle("Sample Webinar");
        response.setDescription("Description of the sample webinar");
//        response.setDate("2024-07-10");
//        response.setTime("10:00:00");
        response.setDuration(60);
        // Add sample participants
//        GetWebinarDetailsResponse.ParticipantsType participants = new GetWebinarDetailsResponse.ParticipantsType();
//        GetWebinarDetailsResponse.ParticipantsType.ParticipantType participant = new GetWebinarDetailsResponse.ParticipantsType.ParticipantType();
//        participant.setParticipantId(1);
//        participant.setName("John Doe");
//        participant.setEmail("john.doe@example.com");
//        participants.getParticipant().add(participant);
//        response.setParticipants(participants);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegisterParticipantRequest")
    @ResponsePayload
    public RegisterParticipantResponse registerParticipant(@RequestPayload RegisterParticipantRequest request) {
        RegisterParticipantResponse response = new RegisterParticipantResponse();
        response.setParticipantId(1); // Sample ID
        response.setStatus("SUCCESS");
        return response;
    }
}

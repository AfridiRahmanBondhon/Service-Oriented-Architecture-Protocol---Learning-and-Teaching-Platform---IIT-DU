package com.wslogin.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wslogin.ws.loginservice.LoginRequest;
import com.wslogin.ws.loginservice.LoginResponse;
import com.wslogin.ws.loginservice.LogoutRequest;
import com.wslogin.ws.loginservice.LogoutResponse;

@Endpoint
public class LoginServiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.wslogin.com/ws/LoginService";

    // Mock user credentials (demo purpose only)
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) {
        LoginResponse response = new LoginResponse();

        // Check if username and password match the predefined credentials
        if (VALID_USERNAME.equals(request.getUsername()) && VALID_PASSWORD.equals(request.getPassword())) {
            response.setStatus(true);
            response.setMessage("Login successful");
        } else {
            response.setStatus(false);
            response.setMessage("Invalid username or password");
        }

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LogoutRequest")
    @ResponsePayload
    public LogoutResponse logout(@RequestPayload LogoutRequest request) {
        LogoutResponse response = new LogoutResponse();

        // Perform logout logic (if any, session handling, etc.)
        response.setStatus(true);
        response.setMessage("Logout successful");

        return response;
    }
}

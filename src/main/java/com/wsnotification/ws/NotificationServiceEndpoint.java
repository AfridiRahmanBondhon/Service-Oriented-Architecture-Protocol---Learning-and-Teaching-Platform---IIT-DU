package com.wsnotification.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.wsnotification.ws.notificationservice.SendNotificationRequestType;
import com.wsnotification.ws.notificationservice.SendNotificationResponseType;

@Endpoint
public class NotificationServiceEndpoint {

    private static final String NAMESPACE_URI = "http://www.wsnotification.com/ws/NotificationService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SendNotificationRequest")
    @ResponsePayload
    public SendNotificationResponseType sendNotification(@RequestPayload SendNotificationRequestType request) {
        SendNotificationResponseType response = new SendNotificationResponseType();

        // Replace with your logic to handle notification sending
        boolean notificationSent = sendNotificationToRecipient(request.getRecipient(), request.getMessage());

        response.setStatus(notificationSent);
        response.setMessage(notificationSent ? "Notification sent successfully" : "Failed to send notification");

        return response;
    }

    // Example method for sending notifications (replace with actual implementation)
    private boolean sendNotificationToRecipient(String recipient, String message) {
        // Implement your notification sending logic here
        // For demo purposes, return true if recipient is not empty and message is not empty
        return recipient != null && !recipient.isEmpty() && message != null && !message.isEmpty();
    }
}

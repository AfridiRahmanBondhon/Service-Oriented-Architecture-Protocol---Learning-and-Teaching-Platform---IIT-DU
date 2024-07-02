package com.wsmakepayment.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import org.wsmakepayment.ws.MakePaymentRequest;
//import org.wsmakepayment.ws.MakePaymentResponse;
import com.wsmakepayment.ws.makepaymentservice.*;

import java.time.LocalDate;

@Endpoint
@Component
public class MakePaymentEndpoint {

    private static final String NAMESPACE_URI = "http://www.wsmakepayment.com/ws/MakePaymentService";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MakePaymentRequest")
    @ResponsePayload
    public MakePaymentResponse makePayment(@Autowired MakePaymentRequest request) {
        MakePaymentResponse response = new MakePaymentResponse();

        // Simulate processing payment logic
        response.setStatus("Payment processed successfully for transaction ID: " + request.getPayment().getTransactionId());

        return response;
    }
}

package com.wsquiz.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.wsquiz.ws.quiz.*;

@Endpoint
@Component
public class QuizEndpoint {

    private static final String NAMESPACE_URI = "http://www.wsquiz.com/ws/quiz";

//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "QuizQuestionRequest")
//    @ResponsePayload
//    public QuizQuestion getQuizQuestion(@RequestPayload QuizQuestion request) {
//        // Implement logic to fetch quiz question based on request
//        // For demonstration, a simple echo of the request is shown
//        return request;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "QuizAnswerRequest")
//    @ResponsePayload
//    public QuizResult submitQuizAnswer(@RequestPayload QuizAnswer request) {
//        // Implement logic to process quiz answer and return result
//        // For demonstration, a dummy result is returned
//        QuizResult result = new QuizResult();
//        result.setScore(8); // Dummy score
//        result.setTotalQuestions(10); // Dummy total questions
//        return result;
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetQuizQuestionRequest")
    @ResponsePayload
    public GetQuizQuestionResponse getQuizQuestion(@RequestPayload GetQuizQuestionRequest request) {
        GetQuizQuestionResponse response = new GetQuizQuestionResponse();
        response.setQuestionId(request.getQuestionId());
        response.setQuestionText("What is the capital of France?");
//        response.getOptions().add("Paris");
//        response.getOptions().add("London");
//        response.getOptions().add("Berlin");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SubmitQuizAnswerRequest")
    @ResponsePayload
    public SubmitQuizAnswerResponse submitQuizAnswer(@RequestPayload SubmitQuizAnswerRequest request) {
        SubmitQuizAnswerResponse response = new SubmitQuizAnswerResponse();
        response.setScore(request.getSelectedOption() == 1 ? 1 : 0); // Assuming option 1 is correct
        response.setTotalQuestions(1);
        return response;
    }
}

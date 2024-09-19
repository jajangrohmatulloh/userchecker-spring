package com.jajangrohmatulloh.userchecker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jajangrohmatulloh.userchecker.model.DecisionResponse;
import com.jajangrohmatulloh.userchecker.model.MatchingLogicRequest;
import com.jajangrohmatulloh.userchecker.model.MatchingLogicResponse;
import com.jajangrohmatulloh.userchecker.model.UserRequest;
import com.jajangrohmatulloh.userchecker.model.UserResponse;
import com.jajangrohmatulloh.userchecker.model.WebResponse;
import com.jajangrohmatulloh.userchecker.service.DecisionService;
import com.jajangrohmatulloh.userchecker.service.MatchingLogicService;
import com.jajangrohmatulloh.userchecker.service.UserService;

@RestController
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private MatchingLogicService matchingLogicService;

    @Autowired
    private DecisionService decisionService;

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse isUserDetected(@RequestBody UserRequest request) {

        UserResponse userResponse = userService.checkFullName(request);

        MatchingLogicRequest matchingLogicRequest = new MatchingLogicRequest();
        matchingLogicRequest.setFullName(request.getFullName());
        matchingLogicRequest.setDBFullNames(userResponse.getUsers());

        MatchingLogicResponse matchingLogicResponse = matchingLogicService.getFullNameScores(matchingLogicRequest);

        DecisionResponse decisionResponse = decisionService.getDecisions(matchingLogicResponse);

        List<String> decisions = decisionResponse.getDecisions();

        WebResponse webResponse = new WebResponse();

        if (decisions.contains("AUTOMATCH")) {
            webResponse.setResult("AUTOMATCH");
        } else if (decisions.contains("AMBIGUOUS")) {
            webResponse.setResult("CANNOT DETERMINE");
        } else {
            webResponse.setResult("CANNOT DETERMINE");
        }

        System.out.println("Almost returning");
        webResponse.setStatus("OK");
        return webResponse;
    }

}

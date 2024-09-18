package com.jajangrohmatulloh.userchecker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jajangrohmatulloh.userchecker.model.DecisionResponse;
import com.jajangrohmatulloh.userchecker.model.MatchingLogicResponse;
import com.jajangrohmatulloh.userchecker.model.UserRequest;
import com.jajangrohmatulloh.userchecker.model.UserResponse;
import com.jajangrohmatulloh.userchecker.model.WebResponse;
import com.jajangrohmatulloh.userchecker.service.DecisionService;
import com.jajangrohmatulloh.userchecker.service.MatchingLogicService;
import com.jajangrohmatulloh.userchecker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MatchingLogicService matchingLogicService;

    @Autowired
    private DecisionService decisionService;
    
    @PostMapping(path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse isUserDetected(@RequestBody UserRequest request) {

        UserResponse userResponse = userService.checkFullName(request);

        MatchingLogicResponse matchingLogicResponse = matchingLogicService.getFullNameScores(userResponse);

        DecisionResponse decisionResponse = decisionService.getDecisions(matchingLogicResponse);

        return WebResponse.builder().status("OK").result(userResult).build();
    }
    
}

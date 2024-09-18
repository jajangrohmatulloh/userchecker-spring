package com.jajangrohmatulloh.userchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jajangrohmatulloh.userchecker.model.DecisionResponse;
import com.jajangrohmatulloh.userchecker.model.MatchingLogicResponse;

@Service
public class DecisionService {

    private final String url = "http://localhost:8083";

    @Autowired
    private RestTemplate restTemplate;

    public DecisionResponse getDecisions(MatchingLogicResponse request) {
        DecisionResponse response = restTemplate.postForObject(url, request, DecisionResponse.class);

        return response;
    }
}

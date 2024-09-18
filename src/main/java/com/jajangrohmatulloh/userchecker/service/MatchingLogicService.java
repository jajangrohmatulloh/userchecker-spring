package com.jajangrohmatulloh.userchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jajangrohmatulloh.userchecker.model.MatchingLogicResponse;
import com.jajangrohmatulloh.userchecker.model.UserResponse;

@Service
public class MatchingLogicService {

    private final String url = "http://localhost:8082";

    @Autowired
    private RestTemplate restTemplate;

    public MatchingLogicResponse getFullNameScores(UserResponse request) {
        MatchingLogicResponse response = restTemplate.postForObject(url, request, MatchingLogicResponse.class);

        return response;
    }
}

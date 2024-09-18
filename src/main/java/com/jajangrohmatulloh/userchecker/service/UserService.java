package com.jajangrohmatulloh.userchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jajangrohmatulloh.userchecker.model.UserRequest;
import com.jajangrohmatulloh.userchecker.model.UserResponse;

@Service
public class UserService {

    private final String url = "http://localhost:8081";

    @Autowired
    private RestTemplate restTemplate;

    public UserResponse checkFullName(UserRequest request) {
        UserResponse response = restTemplate.postForObject(url, request, UserResponse.class);

        return response;
    }

}

package com.jajangrohmatulloh.userchecker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {

    @JsonProperty("full_name")
    private String fullName;

}

package com.jajangrohmatulloh.userchecker.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchingLogicRequest {

    private String fullName;
    private List<String> DBFullNames;
}

package com.jajangrohmatulloh.userchecker.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WebResponse {

    private String status;

    private Data data;

    private String message;

    @Getter
    @Setter
    public static class Data {
        private String result;
    }

}

package com.jajangrohmatulloh.userchecker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse {
    
    private String status;

    private String result;

    private String message;
}

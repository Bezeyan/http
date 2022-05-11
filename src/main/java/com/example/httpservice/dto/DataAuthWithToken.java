package com.example.httpservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataAuthWithToken {
    private String user;
    private String pass;
    private String action;
    private String sender;
    private String message;
    private String target;
    private String token;
    private String address;
    private String userAgent;
}

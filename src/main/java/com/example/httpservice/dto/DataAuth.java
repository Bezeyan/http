package com.example.httpservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataAuth {

    private String login;
    private String pass;
    private String address;
    private String userAgent;

}

package com.example.httpservice.service;

import com.example.httpservice.dto.DataAuth;
import com.example.httpservice.dto.DataAuthWithToken;
import com.example.httpservice.dto.ResponseToken;

public interface DataService {

    DataAuthWithToken createDataAuthWithToken(String login, String pass
            , String action, String sender, String message
            , String target, String address, String userAgent);

    DataAuthWithToken createDataAuthWithToken(DataAuthWithToken dataAuthWithToken);

    ResponseToken getTokenByRequestData(DataAuth dataAuth);

    DataAuth createDataAuth(String login, String pass, String address, String userAgent);

}

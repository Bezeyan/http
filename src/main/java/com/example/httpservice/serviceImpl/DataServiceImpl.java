package com.example.httpservice.serviceImpl;

import com.example.httpservice.dto.DataAuth;
import com.example.httpservice.dto.DataAuthWithToken;
import com.example.httpservice.dto.ResponseToken;
import com.example.httpservice.service.DataService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public DataAuthWithToken createDataAuthWithToken(String login, String pass
            , String action, String sender, String message
            , String target, String address, String userAgent) {
        String token = getTokenByRequestData(createDataAuth(login, pass, address, userAgent)).getToken();
        return new DataAuthWithToken(login, pass, action, sender, message, target, token, address, userAgent);
    }

    @Override
    public DataAuthWithToken createDataAuthWithToken(DataAuthWithToken dataAuthWithToken) {
        String token = getTokenByRequestData(createDataAuth(dataAuthWithToken.getUser(), dataAuthWithToken.getPass(), dataAuthWithToken.getAddress(), dataAuthWithToken.getUserAgent())).getToken();
        dataAuthWithToken.setToken(token);
        return dataAuthWithToken;
    }

    @Override
    public ResponseToken getTokenByRequestData(DataAuth dataAuth) {
        return new ResponseToken("abcd");
    }

    @Override
    public DataAuth createDataAuth(String login, String pass
            , String address, String userAgent) {
        return new DataAuth(login, pass, address, userAgent);
    }

}

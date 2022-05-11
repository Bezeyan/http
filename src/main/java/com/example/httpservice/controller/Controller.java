package com.example.httpservice.controller;


import com.example.httpservice.dto.DataAuthWithToken;
import com.example.httpservice.service.DataService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/rest")
public class Controller {

    private final DataService dataService;

    public Controller(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/authjson")
    public DataAuthWithToken authJson(@RequestBody DataAuthWithToken dataAuthWithToken
            , HttpServletRequest request, @RequestHeader(value = "User-Agent") String userAgent) {

        dataAuthWithToken.setUserAgent(userAgent);
        dataAuthWithToken.setAddress(request.getRemoteAddr());

        return dataService.createDataAuthWithToken(dataAuthWithToken);
    }

    @PostMapping("/authformdata")
    public DataAuthWithToken authFormData(@RequestParam String user, @RequestParam String pass, @RequestParam String action
                                 , @RequestParam String sender, @RequestParam String message, @RequestParam String target
                                 , HttpServletRequest request, @RequestHeader(value = "User-Agent") String userAgent) {

        return dataService.createDataAuthWithToken(user, pass
                , action, sender, message
                , target, request.getRemoteAddr(), userAgent);
    }

    @GetMapping("/authget")
    public DataAuthWithToken authGet(@RequestParam String user, @RequestParam String pass, @RequestParam String action
            , @RequestParam String sender, @RequestParam String message, @RequestParam String target
            , HttpServletRequest request, @RequestHeader(value = "User-Agent") String userAgent) {

        return dataService.createDataAuthWithToken(user, pass
                , action, sender, message
                , target, request.getRemoteAddr(), userAgent);
    }

}

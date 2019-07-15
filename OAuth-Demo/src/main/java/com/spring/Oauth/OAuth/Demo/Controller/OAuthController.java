package com.spring.Oauth.OAuth.Demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

	@GetMapping(value = "/")
    public String index(){
        return "Hello world";
    }

    @GetMapping(value = "/Oauth")
    public String privateArea(){
        return "Welcome To OAuth Page";
    }

}
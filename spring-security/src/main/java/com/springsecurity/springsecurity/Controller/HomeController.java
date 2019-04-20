package com.springsecurity.springsecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "This is Home Page!";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}

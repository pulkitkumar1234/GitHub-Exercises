package com.ReapWebFinal.ReapWebFinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class controller1 {

    @GetMapping("/")
    public ModelAndView dashboard(){
        ModelAndView  modelAndView=new ModelAndView("dashboard");
        return  modelAndView;
    }

    @GetMapping("userlogin")
    public ModelAndView loginuser(){
        ModelAndView  modelAndView=new ModelAndView("loginRegistration");
        return  modelAndView;
    }

    @GetMapping("badges")
    public ModelAndView badges(){
        ModelAndView  modelAndView=new ModelAndView("badges");
        return  modelAndView;
    }

    @GetMapping("adminadmin")
    public ModelAndView admin(){
        ModelAndView  modelAndView=new ModelAndView("adminpanel");
        return  modelAndView;
    }



}

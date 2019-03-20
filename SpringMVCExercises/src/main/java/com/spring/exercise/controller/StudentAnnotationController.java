package com.spring.exercise.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
/*QUESTION 3*/
@Controller
public class StudentAnnotationController {

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    /*QUESTION 4*/
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }


    /*QUESTION 5*/
    @RequestMapping("/student")
    public ModelAndView student(){
        ModelAndView modelAndView = new ModelAndView("student");
        modelAndView.addObject("Hello","Hello World");
        return modelAndView;
    }

    /*QUESTION 6*/
    @RequestMapping("/flname/{firstName}/{lastName}")
    public void firstLastName(@PathVariable("firstName")String first, @PathVariable("lastName")String last){

       /* ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("msg", first+"  "+last);
        return modelAndView;*/
        System.out.println(first + " " + last);
    }

    /*QUESTION 7*/
    @RequestMapping("/firstlast/{firstName}/{lastName}")
    void returnCountryAndState(@PathVariable Map<String, String> requestMap) {
        System.out.println(requestMap.get("firstName") + " " + requestMap.get("lastName"));
    }


    /*QUESTION 8*/
    @ResponseBody
    @RequestMapping(value = "/submit",method = RequestMethod.GET)
    /*ModelAndView*/ String submit(@RequestParam("firstName")String first, @RequestParam("lastName")String last){
        System.out.println(first + " " + last + "  PKJ");
        /*ModelAndView modelAndView=new ModelAndView("Data");
        return modelAndView;*/
        return first + " " + last+ " PKJ";
    }


    /*QUESTION 10*/
    @ModelAttribute
    void addHeading(Model model){
        model.addAttribute("heading","Spring MVC Demo");
    }
    /*QUESTION 9*/
    @ResponseBody
    @RequestMapping("/submitStudent")
    ModelAndView submitObject(Student student){
        ModelAndView modelAndView = new ModelAndView("submitted");
        modelAndView.addObject(student.getFirstName() + " " + student.getLastName());
        System.out.println(student.getFirstName() + " " + student.getLastName());
        //modelAndView.addObject(student);
        return modelAndView;
    }
}



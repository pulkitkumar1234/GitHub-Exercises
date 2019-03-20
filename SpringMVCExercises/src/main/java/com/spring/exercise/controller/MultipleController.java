package com.spring.exercise.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*QUESTION 2*/
public class MultipleController extends MultiActionController {

    public ModelAndView dummy(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        //dummy2(httpServletRequest,httpServletResponse);
        return modelAndView;
    }

    public void dummy2(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<b>HELLO World Again</b>");
    }

}


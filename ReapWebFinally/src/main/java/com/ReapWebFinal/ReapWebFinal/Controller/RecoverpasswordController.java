package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.EmailServiceImpl;
import com.ReapWebFinal.ReapWebFinal.Service.EmployeeService;
import com.ReapWebFinal.ReapWebFinal.Service.WallOfFameService;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/")

public class RecoverpasswordController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    WallOfFameService wallOfFameService;

    @Autowired
    EmailServiceImpl emailService;
    @RequestMapping(value = "/recoverPassword", method = RequestMethod.GET)
    public ModelAndView recover(@RequestParam("email") String email) throws GeneralException {
        ModelAndView modelAndView = new ModelAndView();
        Employee employees = employeeService.findEmployee(email);
        if (employees == null) {
            modelAndView.addObject("msg", "Invalid Email!");
            modelAndView.setViewName("login");
            return modelAndView;
        } else {
            emailService.recoverpassword(employees);
            modelAndView.setViewName("forward:/dashboard");
            return modelAndView;
        }
    }
    @RequestMapping(value = "/recoverPassword", method = RequestMethod.POST)
    public ModelAndView recoverpost(@RequestParam("email") String email) throws GeneralException {
        ModelAndView modelAndView = new ModelAndView();
        Employee employees = employeeService.findEmployee(email);
        if (employees == null) {
            modelAndView.addObject("msg", "Invalid Email!");
            modelAndView.setViewName("login");
            return modelAndView;
        } else {
            emailService.recoverpassword(employees);
            modelAndView.setViewName("forward:/dashboard");
            return modelAndView;
        }
    }
}

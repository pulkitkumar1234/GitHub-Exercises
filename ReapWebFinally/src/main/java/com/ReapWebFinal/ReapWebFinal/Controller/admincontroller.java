package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.EmailServiceImpl;
import com.ReapWebFinal.ReapWebFinal.Service.EmployeeService;
import com.ReapWebFinal.ReapWebFinal.Service.WallOfFameService;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.exception.ZeroBadgeException;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")

public class admincontroller {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    WallOfFameService wallOfFameService;

    @Autowired
    EmailServiceImpl emailService;
    @RequestMapping(value = "/adminadmin", method = RequestMethod.GET)
    public ModelAndView admin(HttpSession httpSession) throws ZeroBadgeException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp1", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("emp", employeeService.allEmpolyeeDetail());
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

    @RequestMapping(value = "/adminadmin", method = RequestMethod.POST)
    public ModelAndView adminpost(HttpSession httpSession) throws ZeroBadgeException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp1", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("emp", employeeService.allEmpolyeeDetail());
        modelAndView.setViewName("adminpage");
        return modelAndView;
    }

    @GetMapping("/deletewalloffame")
    public String deletewalloffame(@RequestParam Integer id){
        wallOfFameService.deletewalloffame(id);
        return "redirect:/dashboard";

    }

    @GetMapping("/updateemployee")
    public String updateemp(@RequestParam Integer id) throws ZeroBadgeException {
        Employee employee=employeeService.findEmployeeById(id);
        employeeService.saveEmp(employee);
        return "redirect:/adminadmin";

    }
    /*@RequestMapping(value = "/findOne", method = RequestMethod.GET)
    @ResponseBody
    public Employee findOne(Integer id) throws ZeroBadgeException {
        return employeeService.findEmployeeById(id);
    }*/
}
package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.*;
import com.ReapWebFinal.ReapWebFinal.entity.*;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
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

    @Autowired
    ProductListImpl productListimpl;

    @Autowired
    CartRepositoryImpl cartRepositoryimpl;

    @Autowired
    ProductBuyedRepositoryImpl productBuyedRepositoryimpl;



    @RequestMapping(value = "/adminadmin", method = RequestMethod.GET)
    public ModelAndView admin(HttpSession httpSession) throws GeneralException {
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
    public ModelAndView adminpost(HttpSession httpSession) throws GeneralException {
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
    public String deletewalloffame(@RequestParam Integer id,HttpSession httpSession) throws GeneralException {

        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            //return modelAndView;
        }
        Employee employee= employeeService.findEmployeeById(id);
        Employee employee1=employeeService.findEmployeeById(employees.getId());

        emailService.badgesRevokedToGiver(employee1);
        emailService.badgesRevokedToReceiver(employee);


        wallOfFameService.deletewalloffame(id);
        emailService.badgesRevokedToGiver(employee);
        return "redirect:/dashboard";

    }

    @GetMapping("/updateemployee")
    public String updateemp(@ModelAttribute Employee employee,HttpSession httpSession) throws GeneralException {
        Employee employeeLogged = (Employee) httpSession.getAttribute("employees");
        if (employeeLogged == null) {
            return "redirect:/login";
        }


        Employee employeeToUpdate = employeeService.findEmployeeById(employee.getId());
        employeeToUpdate.setId(employee.getId());
        employeeToUpdate.setPointsLeftztoUse(employee.getPointsLeftztoUse());
        employeeToUpdate.setPointUsed(employee.getPointUsed());
        employeeToUpdate.setReceivedGoldCount(employee.getReceivedGoldCount());
        employeeToUpdate.setReceivedSilverBadgeCount(employee.getReceivedSilverBadgeCount());
        employeeToUpdate.setReceivedBronzeBadgeCount(employee.getReceivedBronzeBadgeCount());
        employeeToUpdate.setActive(employee.getActive());
        employeeService.saveEmp(employee);
        return "redirect:/adminadmin";

    }



}
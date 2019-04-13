package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.*;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.exception.ZeroBadgeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/")
public class CartAndProductController {
        @Autowired
        EmployeeService employeeService;
        @Autowired
        WallOfFameService wallOfFameService;

        @Autowired
        EmailServiceImpl emailService;

    @Autowired
    CartRepositoryImpl cartRepository;

    @Autowired
    ProductBuyedRepositoryImpl productBuyedRepository;


    @RequestMapping(value = "/cartAndBuy", method = RequestMethod.GET)
    public ModelAndView cartandproduct(HttpSession httpSession) throws ZeroBadgeException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("empl", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("cartProduct",cartRepository.allProductcCart());
        modelAndView.addObject("productBuyed",productBuyedRepository.allBuyedProduct());
        modelAndView.setViewName("cartAndBuy");
        return modelAndView;
    }




}

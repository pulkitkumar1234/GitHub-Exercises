package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.EmailServiceImpl;
import com.ReapWebFinal.ReapWebFinal.Service.EmployeeService;
import com.ReapWebFinal.ReapWebFinal.Service.WallOfFameService;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import com.ReapWebFinal.ReapWebFinal.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    WallOfFameService wallOfFameService;

    @Autowired
    EmailServiceImpl emailService;
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)   //Working
    public ModelAndView root(HttpSession httpSession) {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        //redirectAttributes.addAttribute("loginError");
       // redirectAttributes.addAttribute("success");
        modelAndView.setViewName("forward:/dashboard");
        return modelAndView;
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET) //Working, partitally
    public ModelAndView login(HttpSession httpSession) {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        //redirectAttributes.addAttribute("loginError");
        //redirectAttributes.addAttribute("success");
        modelAndView.addObject("wof",new WallOfFame());
        //modelAndView.setViewName("redirect:/dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST) //Working partitally
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
                              HttpSession httpSession) {

        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees != null) {
            employees.setEmail(username);
            httpSession.setAttribute("employees", employees);
            modelAndView.setViewName("redirect:/dashboard");
            return modelAndView;
        }
        try {
            String id = username;
            employees = employeeService.FindByEmailAndPassword(id, password);

        }catch (UserNotFoundException usernotfoundexception)
        {
            System.out.println(usernotfoundexception.getMessage());
        }


        if (employees == null) {
            modelAndView.addObject("msg", "Invalid Credentials!");
            modelAndView.setViewName("login");
            return modelAndView;
        }

       // redirectAttributes.addAttribute("loginError");
      //  redirectAttributes.addAttribute("success");
        httpSession.setAttribute("employees", employees);
       // modelAndView.addObject("wof",new WallOfFame());
        modelAndView.setViewName("redirect:/dashboard");
        return modelAndView;
    }

}

package com.thymeleaf.exercise.thymeleafexercise.controller;

import com.thymeleaf.exercise.thymeleafexercise.Employee;
import com.thymeleaf.exercise.thymeleafexercise.User;
import com.thymeleaf.exercise.thymeleafexercise.employee;
import com.thymeleaf.exercise.thymeleafexercise.enums.usertype;
import com.thymeleaf.exercise.thymeleafexercise.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class HomeController {


    //Question 1
    @GetMapping("buttonClick")
    public String button(){
        return "Question1";
    }

    //Question 3
    @GetMapping("changecolor")
    public String color(){
        return "hello";
    }

    //Question 3
    @RequestMapping("employeereg")
    public ModelAndView showRegForm(){
        ModelAndView modelAndView=new ModelAndView("EmployeeRegistrationForm");
        modelAndView.addObject("employee",new employee());
        return modelAndView;
    }

    @PostMapping("signup")
    public ModelAndView signup(@ModelAttribute employee employee){
        ModelAndView modelAndView=new ModelAndView("signup");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    //Question 4
    List<Employee> employeeList = new ArrayList<>();
    @GetMapping("/dynamicEmployeeRegistration")
    public ModelAndView getEmployee() {
        ModelAndView modelAndView = new ModelAndView("DynamicEmployeeRegistration");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/dynamicEmployeeRegistration")
    public ModelAndView setEmployee(Employee employee) {
        employeeList.add(employee);
        ModelAndView modelAndView = new ModelAndView("DynamicEmployeeTable");
        modelAndView.addObject("employee",employeeList);
        return modelAndView;
    }

    //Question 5
    @RequestMapping("usertype")
    public ModelAndView showusertype(){
        ModelAndView modelAndView=new ModelAndView("userType");
        modelAndView.addObject("user", new user());
        return modelAndView;
    }

    @PostMapping("greetings")
    public ModelAndView showuser(@ModelAttribute user user){
        ModelAndView modelAndView=new ModelAndView("greetings");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    /*@RequestMapping(value = "userstype", method = RequestMethod.GET)
    public String fetchUserType(Model M){

        return "user";
    }*/

    List<usertype> usertype = new ArrayList<>();
    public List<usertype> getUsers(){
        return usertype;
    }
/*
    @GetMapping("list")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("user");
        view.addObject("users",getUsers());
        return view;
    }*/


//Question 9
    @GetMapping("/getEnums")
    public ModelAndView getEnums()
    {
        ModelAndView modelAndView = new ModelAndView("user");
        return modelAndView;
    }

    //Question 6

    @GetMapping("/serverTime")
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("servertime");
        return modelAndView;
    }


    @GetMapping("/time")
    public String getTime() {
        return LocalTime.now() + "";
    }

    //Question 8

    @SuppressWarnings("Duplicates")
    @GetMapping("/getList")
    public ModelAndView userList()
    {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setFirstName("Pulkit");
        user1.setLastName("Kumar");
        user1.setSalary(2000);
        User user2 = new User();
        user2.setFirstName("Gagan");
        user2.setLastName("Khushwah");
        user2.setSalary(2000);
        User user3 = new User();
        user3.setFirstName("Prateek");
        user3.setLastName("Nagar");
        user3.setSalary(2000);
        User user4 = new User();
        user4.setFirstName("Arpit");
        user4.setLastName("Gupta");
        user4.setSalary(2000);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        ModelAndView modelAndView = new ModelAndView("ColorList");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }



//Question 10
    @GetMapping("/registrationForm")
    public ModelAndView getRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("RegistrationForm");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/registrationForm")
    public String submitRegistrationForm(@ModelAttribute("e") Employee employee) {

        try {
            Thread.currentThread().sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Successfully Form Submitted";
    }
}

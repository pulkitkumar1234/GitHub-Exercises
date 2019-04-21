package com.springsecurity.springsecurity.Controller;

import com.springsecurity.springsecurity.entity.User;
import com.springsecurity.springsecurity.entity.VerificationToken;
import com.springsecurity.springsecurity.repository.UserRepository;
import com.springsecurity.springsecurity.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    VerificationTokenRepository verificationTokenRepository;
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

    @RequestMapping("/register")
    public String register()
    {

        return "registration";
    }


    /*@RequestMapping("/registerUser")
    public String registerUser(User user)
    {
        user.setEnabled(false);
        userRepository.save(user);
        return "login";
    }*/
    @RequestMapping("/registerUser")
    public String registerUser(User user, HttpServletRequest httpServletRequest){
        String token= UUID.randomUUID().toString();
        user.setEnabled(false);
        userRepository.save(user);
        String authUrl="http://"+httpServletRequest.getServerName()
                + ":"
                +httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath()
                +"/registerConfirmation"
                +"?token="+token;
        System.out.println("Recovery URL:"+authUrl);

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        verificationTokenRepository.delete(verificationToken.getId());

        return "login";
    }

    @RequestMapping("/registerConfirmation")
    public String registrationConfirmation(String token){
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        User user =verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/login";
    }
}

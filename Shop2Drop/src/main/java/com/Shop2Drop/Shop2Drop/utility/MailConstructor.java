package com.Shop2Drop.Shop2Drop.utility;

import com.Shop2Drop.Shop2Drop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;
@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user,String password){
        String url=contextPath+"/newUser?token="+token;
        String message="\nPlease Click on This link to verify your email and edit your personal information. Your password is: \n"+password;
        SimpleMailMessage email=new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Shop2Drop-New User");
        email.setText(url+message);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}

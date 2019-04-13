package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl  {

    public JavaMailSender javaMailSender;

@Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailOnRegistration(Employee employee) throws MailException{
    SimpleMailMessage mailMessage=new SimpleMailMessage();
    mailMessage.setTo(employee.getEmail());
    mailMessage.setFrom("pulkitkumar241@gmail.com");
    mailMessage.setSubject("Registration Successfull!");
    mailMessage.setText("You Have Been Successfully Registered to Reap");
    javaMailSender.send(mailMessage);
    }
    public void sendEmailWhenBagdgeShared(Employee employee) throws MailException{
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(employee.getEmail());
        mailMessage.setFrom("pulkitkumar241@gmail.com");
        mailMessage.setSubject(employee.getFirstname()+"Recognized by You");
        mailMessage.setText(employee.getFirstname()+"have Been Recognized by Someone");
        javaMailSender.send(mailMessage);
    }
    public void sendEmailWhenBagdgeReceived(Employee employee) throws MailException{
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(employee.getEmail());
        mailMessage.setFrom("pulkitkumar241@gmail.com");
        mailMessage.setSubject(employee.getFirstname()+" is Recognized");
        mailMessage.setText("You Have Been Recognized by Someone");
        javaMailSender.send(mailMessage);
    }

    public void recoverpassword(Employee employee) throws MailException{
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(employee.getEmail());
        mailMessage.setFrom("pulkitkumar241@gmail.com");
        mailMessage.setSubject("Your Passwod");
        mailMessage.setText("This is Your Password"+employee.getPassword());
        javaMailSender.send(mailMessage);
    }

}

package com.ReapWebFinal.ReapWebFinal.events;
import com.ReapWebFinal.ReapWebFinal.entity.*;
import com.ReapWebFinal.ReapWebFinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.IntStream;

@Component
public class Bootstrap {


   @Autowired
   EmployeeRepository employeeRepository;
   @Autowired
   WallOfFameRepository wallOfFameRepository;

    @EventListener(ApplicationStartedEvent.class)
    void setUp(){
        if(!employeeRepository.findAll().iterator().hasNext()) {
            IntStream.range(0, 10).forEach(e -> {
                Employee employee = new Employee();
                employee.setFirstname("Firstname"+1);
                employee.setLastname("Lastname"+e);
                employee.setEmail(e+"kk@tothenew.com");
                employee.setPassword(e+"123");
                employee.setImagepath("images/profile"+e);
                employee.setActive(true);
                employeeRepository.save(employee);
            });
        }

        if(!wallOfFameRepository.findAll().iterator().hasNext()) {

            IntStream.range(0, 10).forEach(e -> {
                WallOfFame wallOfFame = new WallOfFame();
                wallOfFame.setGiverName("Givername"+e);
                wallOfFame.setReceiverName("Receivername"+e);
                wallOfFame.setGiverId(e+1);
                wallOfFame.setReceiverId(e+1);
                wallOfFame.setReason("Reason"+e);
                wallOfFame.setKarma("Karma"+e);
                wallOfFame.setBadgeType("Badge"+e);
                wallOfFame.setGivenDateAndTime(new Date());
                wallOfFameRepository.save(wallOfFame);

            });
        }

    }

}

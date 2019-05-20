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

   @Autowired
   ProductListRepository productListRepository;

   @Autowired
   CartRepository cartRepository;

   @Autowired
   ProductBuyedRepository productBuyedRepository;

    @EventListener(ApplicationStartedEvent.class)

    void setUp(){
        if(!employeeRepository.findAll().iterator().hasNext()) {
            IntStream.range(0, 10).forEach(e -> {
                Employee employee = new Employee();
                employee.setFirstname("Firstname"+1);
                employee.setLastname("Lastname"+e);
                employee.setEmail(e+"kk@tothenew.com");
                employee.setPassword(e+"123");
                employee.setImagepath("/images/profiles/default_Male.jpg");
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

        if(!productListRepository.findAll().iterator().hasNext()) {

            IntStream.range(0, 5).forEach(e -> {
                ProductList productList = new ProductList();
                productList.setProductImage("/image/product1/");
                productList.setProductname("Product "+e);
                productList.setPointsToRedeem(49+e);
                productList.setStock(9+e);
                productListRepository.save(productList);

            });
        }

        if(!cartRepository.findAll().iterator().hasNext()) {

            IntStream.range(0, 5).forEach(e -> {
                Cart cart = new Cart();
               cart.setProductId(e+1);
               cart.setProductImage("/image/product1/");
               cart.setProductname("Product "+e);
               cart.setPointsToRedeem(49+e);
               cart.setCartOwnerId(e+1);
               cartRepository.save(cart);

            });
        }

        if(!productBuyedRepository.findAll().iterator().hasNext()) {

            IntStream.range(0, 5).forEach(e -> {
                ProductBuyed productBuyed = new ProductBuyed();
                productBuyed.setProductId(e+1);
                productBuyed.setProductname("Product "+e);
                productBuyed.setProductImage("/image/product1/");
                productBuyed.setProductOwnerId(e+1);

                productBuyedRepository.save(productBuyed);

            });
        }

    }

}

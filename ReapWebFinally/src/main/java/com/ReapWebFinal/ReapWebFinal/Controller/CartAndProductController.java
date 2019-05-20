package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.*;
import com.ReapWebFinal.ReapWebFinal.entity.Cart;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.ProductBuyed;
import com.ReapWebFinal.ReapWebFinal.entity.ProductList;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    CartRepositoryImpl cartRepositoryimpl;

    @Autowired
    ProductBuyedRepositoryImpl productBuyedRepositoryimpl;

    @Autowired
    ProductListImpl productListimpl;


    @RequestMapping(value = "/cartAndBuy", method = RequestMethod.GET)
    public ModelAndView cartandproduct(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("empl", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("cartProduct",cartRepositoryimpl.allProductcCart(employees.getId()));
        modelAndView.addObject("productBuyed",productBuyedRepositoryimpl.allBuyedProduct(employees.getId()));
        modelAndView.setViewName("cartAndBuy");
        return modelAndView;
    }

    @GetMapping("/addtocart")
    public  String addtocart(@RequestParam Integer id, HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");

        if (employees == null) {
            return "redirect:/login";
        }
        else {
            ProductList productList= productListimpl.findProduct(id);
            int stock=productList.getStock();
            int goldCount=employees.getReceivedGoldCount();
            int silverCount= employees.getReceivedSilverBadgeCount();
            int bronzeCount=employees.getReceivedBronzeBadgeCount();

            int totalpoints=goldCount*30+silverCount*20+bronzeCount*10;

            int pointsToRedeem=productList.getPointsToRedeem();
            if(totalpoints>pointsToRedeem && stock>0){
                Cart cart=new Cart();
                cart.setProductId(productList.getId());
                cart.setProductImage(productList.getProductImage());
                cart.setProductname(productList.getProductname());
                cart.setPointsToRedeem(productList.getPointsToRedeem());;
                cart.setCartOwnerId(employees.getId());
                System.out.println("user cart"+cart);
                Cart success= cartRepositoryimpl.saveToCart(cart);
                System.out.println(success.toString());
                System.out.println(success);
                if(success!=null)
                {
                    productList.setStock(productList.getStock()-1);
                    productListimpl.save(productList);
                    int pointLeft=employees.getTotalPoints()-pointsToRedeem;
                    employees.setPointsLeftztoUse(pointLeft);
                    employeeService.saveEmployee(employees);
                }

                return "redirect:/cartAndBuy";

            } else {
                return "redirect:/redeem";
            }
        }
    }

    @GetMapping("/buyProduct")
    public  String buyProduct(@RequestParam Integer id,HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");

        if (employees == null) {
            return "redirect:/login";
        }
        else {
            try{
                Cart cart=cartRepositoryimpl.findProductInCart(id);
                ProductBuyed productBuyed=new ProductBuyed();
                productBuyed.setProductname(cart.getProductname());
                productBuyed.setProductId(cart.getProductId());
                productBuyed.setProductImage(cart.getProductImage());
                productBuyed.setPointToRedeem(cart.getPointsToRedeem());
                productBuyed.setProductOwnerId(cart.getCartOwnerId());
                ProductBuyed productBuyed1=productBuyedRepositoryimpl.saveBuyedProduct(productBuyed);
                if(productBuyed1!=null) {
                    cartRepositoryimpl.deleteFromCart(id);
                }
                return "redirect:/cartAndBuy";
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return "redirect:/cartAndBuy";

        }
    }


    @GetMapping("/removeFromCart")
    public  String removeFromCart(@RequestParam Integer id,HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");

        if (employees == null) {
            return "redirect:/login";
        }
        else {
            try {
                cartRepositoryimpl.deleteFromCart(id);
                ProductList productList=productListimpl.findProduct(id);
                int pointtoredeem=productList.getPointsToRedeem();
                productList.setStock(productList.getStock()+1);
                employees.setPointsLeftztoUse(employees.getPointsLeftztoUse()+pointtoredeem);
                employees.setTotalPoints(employees.getTotalPoints()+pointtoredeem);
                employeeService.saveEmployee(employees);


            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
        return "redirect:/cartAndBuy";
    }



}

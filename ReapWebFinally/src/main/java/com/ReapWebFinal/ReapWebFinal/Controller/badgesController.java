package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.*;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")

public class badgesController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    WallOfFameService wallOfFameService;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    ProductListImpl productList;


    //BADGES PAGES
    @RequestMapping(value = "/badges", method = RequestMethod.GET)
    public ModelAndView badges(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",wallOfFameService.allBadgeTransactionOfEmployeebyId(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("allreceivedBadges", wallOfFameService.allBadgeTransactionOfEmployee(employees.getId(),employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badges");
        return modelAndView;
    }

    @RequestMapping(value = "/shared", method = RequestMethod.GET)
    public ModelAndView shared(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allSharedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("sharedBadges", wallOfFameService.allSharedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badgesShared");
        return modelAndView;
    }

    @RequestMapping(value = "/received", method = RequestMethod.GET)
    public ModelAndView received(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("receivedBadges", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badgesReceived");
        return modelAndView;
    }

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    public ModelAndView points(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("receivedBadges", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("sharedBadges", wallOfFameService.allSharedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("allreceivedBadges", wallOfFameService.allBadgeTransactionOfEmployeebyId(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badgespoints");
        return modelAndView;
    }

    @RequestMapping(value = "/redeem", method = RequestMethod.GET)
    public ModelAndView redeem(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("userBadgeTransactions", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("RedeemPoints");
        return modelAndView;
    }

    @RequestMapping(value = "/redeem", method = RequestMethod.POST)
    public ModelAndView redeempost(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("userBadgeTransactions", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("RedeemPoints");
        return modelAndView;
    }

    @RequestMapping(value = "/badges/{uid}") //not checked
    public ModelAndView badgesOfUserId(@PathVariable String id, HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        int empid=Integer.parseInt(id);
        Employee employee =employeeService.findEmployeeById(empid);
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allBadgeTransactionOfEmployeebyId(empid));
        modelAndView.addObject("emp", employeeService.findEmployee(employee.getEmail()));
        modelAndView.addObject("allreceivedBadges", wallOfFameService.allBadgeTransactionOfEmployee(employee.getId(),employee.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.addObject("receivedBadges", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employee.getId()));
        modelAndView.setViewName("badges");
        return modelAndView;
    }


    @RequestMapping(value = "/shared/{uid}", method = RequestMethod.GET)
    public ModelAndView shareduid(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allSharedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("sharedBadges", wallOfFameService.allSharedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badgesShared");
        return modelAndView;
    }

    @RequestMapping(value = "/received/{uid}", method = RequestMethod.GET)
    public ModelAndView receiveduid(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("receivedBadges", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badgesReceived");
        return modelAndView;
    }

    @RequestMapping(value = "/points/{uid}", method = RequestMethod.GET)
    public ModelAndView pointsuid(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("receivedBadges", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("sharedBadges", wallOfFameService.allSharedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("allreceivedBadges", wallOfFameService.allBadgeTransactionOfEmployeebyId(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("badgespoints");
        return modelAndView;
    }

    @RequestMapping(value = "/redeem/{uid}", method = RequestMethod.GET)
    public ModelAndView redeemuid(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("userBadgeTransactions", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("RedeemPoints");
        return modelAndView;
    }

    @RequestMapping(value = "/redeem/{uid}", method = RequestMethod.POST)
    public ModelAndView redeempostuid(HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("userBadgeTransactions", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.addObject("productlist",productList.allProduct());
        modelAndView.setViewName("RedeemPoints");
        return modelAndView;
    }



}

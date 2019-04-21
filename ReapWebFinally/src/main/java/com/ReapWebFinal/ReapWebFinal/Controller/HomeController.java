package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.EmailServiceImpl;
import com.ReapWebFinal.ReapWebFinal.Service.EmployeeService;
import com.ReapWebFinal.ReapWebFinal.Service.WallOfFameService;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.SearchEmployeeDTO;
import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import com.ReapWebFinal.ReapWebFinal.exception.ZeroBadgeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    WallOfFameService wallOfFameService;

    @Autowired
    EmailServiceImpl emailService;


    @RequestMapping(value = "/register", method = RequestMethod.GET) //Working,  need to work on validation
    public ModelAndView register(HttpSession httpSession) {
        Employee employees = (Employee) httpSession.getAttribute("users");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("employees", new Employee());
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST) //Working,  need to work on validation
    public ModelAndView register(@ModelAttribute Employee employees, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        Employee employeeSession = (Employee) httpSession.getAttribute("employees");


        if (employeeSession != null) {
            httpSession.setAttribute("employees", employees);
            modelAndView.setViewName("redirect:/dashboard");
            return modelAndView;
        }

        Employee success = employeeService.saveEmployee(employees);
        String accessed = success.getEmail();

        if (accessed != null) {
            emailService.sendEmailOnRegistration(employees);
            httpSession.setAttribute("employees", employees);

            modelAndView.setViewName("redirect:/dashboard");
            return modelAndView;
        } else {
            if (accessed == null)
                modelAndView.addObject("msg", "This email already exists!! Please choose another one");
            else
                modelAndView.addObject("msg", "Something went wrong! Please try again.");

            modelAndView.setViewName("register");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET) //Working
    public ModelAndView homeget(HttpSession httpSession) throws ZeroBadgeException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
       modelAndView.addObject("wof", new WallOfFame());
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.setViewName("dashboard");
        System.out.println(employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("walloffame", wallOfFameService.AllBadgeTransaction());
        modelAndView.addObject("lastsevendays", employeeService.LastSevenDay());
        return modelAndView;

    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST) //Working,  need to work on validation and links
    public ModelAndView home(HttpSession httpSession) throws ZeroBadgeException {
        Employee employees = (Employee) httpSession.getAttribute("employees");

//        System.out.println(employees.get);
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
       modelAndView.addObject("wof", new WallOfFame());
        modelAndView.addObject("emp", employeeService.findEmployee(employees.getEmail()));
        modelAndView.addObject("walloffame", wallOfFameService.AllBadgeTransaction());
        modelAndView.addObject("lastsevendays", employeeService.LastSevenDay());

        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)  //not checked
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = {"/karma"}, method = RequestMethod.GET)  //not checked
    public ModelAndView karma(HttpSession httpSession) {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!");
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        //modelAndView.addObject("walloffame", new WallOfFame());
        modelAndView.setViewName("redirect:/dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/karma", method = RequestMethod.POST) //not checked
    public ModelAndView recognizeKarma(@ModelAttribute WallOfFame wallOfFame, HttpSession httpSession) throws ZeroBadgeException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!");
            modelAndView.setViewName("redirect:/login");
        }
        

        wallOfFame.setGiverId(employees.getId());
        wallOfFame.setGiverName(employees.getFirstname());
        //Set from The data set when from recognize button is clicked
        wallOfFame.setReceiverId(wallOfFame.getReceiverId());
        wallOfFame.setReceiverName(wallOfFame.getReceiverName());
        wallOfFame.setBadgeType(wallOfFame.getBadgeType());
        wallOfFame.setKarma(wallOfFame.getKarma());
        wallOfFame.setReason(wallOfFame.getReason());
        wallOfFame.setGivenDateAndTime(wallOfFame.getGivenDateAndTime());
        wallOfFame.setGivenDateAndTime(new Date());

        int success = wallOfFameService.saveTransaction(wallOfFame);

        Integer receiverid = wallOfFame.getReceiverId();
        Employee employee = employeeService.findEmployeeById(receiverid);

        if (success == 1) {
            emailService.sendEmailWhenBagdgeShared(employees);
            emailService.sendEmailWhenBagdgeReceived(employee);
        }

        Employee EmployeereceivedBadges = employeeService.getReceivedBadgesOfEmployee(employees.getEmail());
        modelAndView.addObject("receivedBadges", EmployeereceivedBadges);

        Employee EmployeeremainingBadges = employeeService.getRemainingBadgesOfEmployee(employees.getEmail());
        modelAndView.addObject("remainingBadges", EmployeeremainingBadges);

        modelAndView.addObject("successMessage", success);
        modelAndView.setViewName("redirect:/dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json") //not checked
    @ResponseBody
    public List<Employee> getUsers(@RequestParam String term, HttpServletResponse response, HttpSession session) {
        return employeeService.searchNewer(term);
    }

    //Badges of perticular User id
    @RequestMapping(value = "/badges/index/{uid}") //not checked
    public ModelAndView badgesOfUserId(@PathVariable String id, HttpSession httpSession) {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!!");
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }
        modelAndView.addObject("userBadgeTransactions",
                wallOfFameService.allBadgeTransactionOfEmployeebyId(Integer.parseInt(id)));
        modelAndView.addObject("receivedBadges", wallOfFameService.allReceivedBadgeTransactionOfEmployee(employees.getId()));
        modelAndView.setViewName("badges");
        return modelAndView;
    }


    /*   @RequestMapping(value = "/usernameautocomplete")
       @ResponseBody
       public List<String> usernamecomplete(@RequestParam (value = "term", required=false,defaultValue="")String term){
           List<String> suggession=new ArrayList<>();
           List<Employee> employees=new ArrayList<>();

           for (Employee emp:employeeService.searchNewer(term)) {
               employees.add(emp);
               SearchEmployeeDTO searchEmployeeDTO=new SearchEmployeeDTO();
               searchEmployeeDTO.setUserFirstName(emp.getFirstname());
               searchEmployeeDTO.setUserid(emp.getId());
               suggession.add(searchEmployeeDTO.toString());
           }
           return suggession;
       }
   */
    @RequestMapping(value = "/usernameautocomplete")
    @ResponseBody
    public List<String> usernamecomplete(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        List<String> suggession = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        //employees=employeeService.searchNewer(term);
        for (Employee emp : employeeService.searchNewer(term)) {
            SearchEmployeeDTO su = new SearchEmployeeDTO();
            su.setUserFirstName(emp.toString());
            su.setFirstNameValue(Integer.toString(emp.getId()));
            suggession.add(emp.getFirstname());
        }
        return suggession;
    }


}

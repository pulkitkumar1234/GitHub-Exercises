package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.EmailServiceImpl;
import com.ReapWebFinal.ReapWebFinal.Service.EmployeeService;
import com.ReapWebFinal.ReapWebFinal.Service.WallOfFameService;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.Roles;
import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import com.ReapWebFinal.ReapWebFinal.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    WallOfFameService wallOfFameService;

    @Autowired
    EmailServiceImpl emailService;



    private static String UPLOADED_FOLDER = "/home/ttn/IdeaProjects/ReapWebFinally/out/production/resources/static/images/profiles";



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

        try {
            String userImage = UUID.randomUUID().toString() + ".png";
            Path path = Paths.get(UPLOADED_FOLDER, userImage);
            path = Files.write(path, employees.getMultipartFile().getBytes());
            employees.setImagepath("/images/profiles/" + userImage);
        } catch (IOException e) {
            e.printStackTrace();
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
    public ModelAndView homeget(HttpSession httpSession) throws GeneralException {
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

        /*boolean isAdmin =employees.getRoleSet().contains(Roles.ADMIN);
        System.out.println(isAdmin);
        if (isAdmin){
            modelAndView.addObject("isAdmin",isAdmin);
            List<Employee> userList = employeeService.findAllEmployee();
            modelAndView.addObject("users",userList);
        }*/
        return modelAndView;

    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST) //Working,  need to work on validation and links
    public ModelAndView home(HttpSession httpSession) throws GeneralException {
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
    public ModelAndView recognizeKarma(@ModelAttribute WallOfFame wallOfFame, HttpSession httpSession) throws GeneralException {
        Employee employees = (Employee) httpSession.getAttribute("employees");
        ModelAndView modelAndView = new ModelAndView();
        if (employees == null) {
            modelAndView.addObject("msg", "Please login first!!!");
            modelAndView.setViewName("redirect:/login");
        }

        WallOfFame wallOfFame1=new WallOfFame();

        Employee receiverEmployee=employeeService.findEmployeeById(wallOfFame.getReceiverId());

        if(receiverEmployee==null){
            throw new UserNotFoundException("No Employee Available");
        }

        int loggegInUserId=employees.getId();
        int receiverEmpId=receiverEmployee.getId();

        if(loggegInUserId==receiverEmpId){
            modelAndView.addObject("msg", "You Cannot Recognize Your Self");
            modelAndView.setViewName("redirect:/dashboard");
            return modelAndView;
        }else {

            wallOfFame1.setGiverId(employees.getId());
            wallOfFame1.setGiverName(employees.getFirstname()+" "+employees.getLastname());

            //Set from The data set when from recognize button is clicked

            wallOfFame1.setReceiverId(receiverEmployee.getId());
            wallOfFame1.setReceiverName(receiverEmployee.getFirstname()+" "+receiverEmployee.getLastname());
            wallOfFame1.setBadgeType(wallOfFame.getBadgeType());
            wallOfFame1.setKarma(wallOfFame.getKarma());
            wallOfFame1.setReason(wallOfFame.getReason());
            wallOfFame1.setGivenDateAndTime(new Date());

            int success = wallOfFameService.saveTransaction(wallOfFame1);
            if (success == 1) {
                emailService.sendEmailWhenBagdgeShared(employees);
                emailService.sendEmailWhenBagdgeReceived(receiverEmployee);
            }

            Employee EmployeereceivedBadges = employeeService.getReceivedBadgesOfEmployee(employees.getEmail());
            modelAndView.addObject("receivedBadges", EmployeereceivedBadges);

            Employee EmployeeremainingBadges = employeeService.getRemainingBadgesOfEmployee(employees.getEmail());
            modelAndView.addObject("remainingBadges", EmployeeremainingBadges);

            modelAndView.addObject("successMessage", success);
            modelAndView.setViewName("redirect:/dashboard");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json") //not checked
    @ResponseBody
    public List<Employee> getUsers(@RequestParam String term, HttpServletResponse response, HttpSession session) {
        return employeeService.searchNewer(term);
    }

    //Badges of perticular User id


    @RequestMapping(value="/fetchUserByName")
    @ResponseBody
    public String receiverNameAutocomplete(@RequestParam(value = "uData",required = false, defaultValue = "") String uData) throws Exception {

        List<Employee> employeeList=employeeService.searchNewer(uData);
        int count=0;

        List<String> userDetails=new ArrayList<>();

        for(Employee u:employeeList) {

            String displayData="<span onclick='finalizeSearch(this.id);' id='"+u.getId()+"'>"+u.getFirstname() +" "+u.getLastname()+" ( "+u.getEmail()+" )</span><br />";
            userDetails.add(displayData);


        }

        return userDetails.toString();
    }

}


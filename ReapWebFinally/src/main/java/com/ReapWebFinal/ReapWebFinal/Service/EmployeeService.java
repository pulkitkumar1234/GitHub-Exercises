package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import com.ReapWebFinal.ReapWebFinal.exception.UserNotFoundException;
import com.ReapWebFinal.ReapWebFinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

   public Employee findEmployee(String email) throws GeneralException {
         Optional<Employee> employee=employeeRepository.findAllByEmail(email);
         Employee employee1=employee.orElse(null);
         if (employee1==null){
             throw new GeneralException();
         }
         return employee1;
    }

    public Employee FindByEmailAndPassword(String email, String password){
       return  employeeRepository.findByEmailAndPassword(email,password);
    }

    public Employee saveEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public boolean updateReceivedGold(int id) throws GeneralException {


        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            throw new UserNotFoundException("No User Available");
        }
        int goldCount=employee1.getReceivedGoldCount();
        employee1.setReceivedGoldCount(goldCount+1);
        employeeRepository.save(employee1);
        return true;

    }

    //@Modifying
    public boolean updateReceivedSilver(int id) throws GeneralException {

        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            throw new UserNotFoundException("No User Available");
        }
        int silvercount=employee1.getReceivedSilverBadgeCount();
        employee1.setReceivedSilverBadgeCount(silvercount+1);
        employeeRepository.save(employee1);
        return true;

    }
    //@Modifying
    public boolean updateReceivedBronze(int id) throws GeneralException {

        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            throw new UserNotFoundException("No User Availabl");
        }
        int bronzeBadgeCount=employee1.getReceivedBronzeBadgeCount();
        employee1.setReceivedBronzeBadgeCount(bronzeBadgeCount+1);
        employeeRepository.save(employee1);
        return true;

    }



    public boolean updateRemainingGold(Integer id) throws GeneralException {

        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employee1 = employee.orElse(null);
        if (employee1 == null) {
            throw new UserNotFoundException("No User Availabl");
        }

        int goldBadgeCount = employee1.getShareableGoldBadgeCount();
        //System.out.println("Employyee :"+ goldBadgeCount);
        if (goldBadgeCount > 0){
            employee1.setShareableGoldBadgeCount(goldBadgeCount - 1);
        employeeRepository.save(employee1);
        System.out.println("EMPLOYEE:" + employee1.toString());
        return true;
    }
        else {
           return false;
        }

    }

    //@Modifying
    public boolean updateRemainingSilver(int id) throws GeneralException {


        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            throw new UserNotFoundException("No User Availabl");
        }

        int shareableSilverBadgeCount =employee1.getShareableSilverBadgeCount();
        if (shareableSilverBadgeCount == 0){
            employee1.setShareableSilverBadgeCount(shareableSilverBadgeCount - 1);
            employeeRepository.save(employee1);
            return true;
        }

        else {
                return false;
        }


    }
    //@Modifying
    public boolean updateRemainingBronze(int id) throws GeneralException {


        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            throw new UserNotFoundException("No User Available");
        }

        int bronzeBadgeCount=employee1.getShareableBronzeBadgeCount();
        if (bronzeBadgeCount == 0){
            employee1.setShareableBronzeBadgeCount(bronzeBadgeCount - 1);
            employeeRepository.save(employee1);
            return true;
        }

        else {
            return false;
        }

    }

        public Employee  getReceivedBadgesOfEmployee(String email) throws GeneralException {
            Optional<Employee> employee=employeeRepository.findAllByEmail(email);
            Employee employee1=employee.orElse(null);
            if (employee1==null){
                throw new UserNotFoundException("No User Available");
            }
            return employee1;

        }

        public Employee getRemainingBadgesOfEmployee(String email) throws GeneralException {
            Optional<Employee> employee=employeeRepository.findAllByEmail(email);
            Employee employee1=employee.orElse(null);
            if (employee1==null){
                throw new UserNotFoundException("No User Available");
            }
            return employee1;

        }

        public List<Employee> searchNewer(String term){
          return  employeeRepository.findByFirstnameContaining(term);
        }

        public List<Employee> LastSevenDay(){
          Iterable<Employee> iterable=employeeRepository.findAll();
          List<Employee> employees=new ArrayList<>();
          for(Employee i: iterable)
              employees.add(i);

          return employees;
        }
    public List<Employee> allEmpolyeeDetail(){
        Iterable<Employee> iterable=employeeRepository.findAll();
        List<Employee> employees=new ArrayList<>();
        for(Employee i: iterable)
            employees.add(i);

        return employees;
    }

   public Employee findEmployeeById(Integer id) throws GeneralException {
        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            //throw new GeneralException();
        }
        return employee1;
    }


    public void saveEmp(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> findUserByEmail(String email){
        return employeeRepository.findAllByEmail(email);
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
      Iterable<Employee> iterable= employeeRepository.findAll();
      List<Employee> employeeList=new ArrayList<>();
        for(Employee i: iterable)
            employeeList.add(i);

        return employeeList;
    }
}

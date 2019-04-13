package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.exception.ZeroBadgeException;
import com.ReapWebFinal.ReapWebFinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

   public Employee findEmployee(String email) throws ZeroBadgeException {
         Optional<Employee> employee=employeeRepository.findAllByEmail(email);
         Employee employee1=employee.orElse(null);
         if (employee1==null){
             throw new ZeroBadgeException();
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

    public boolean updateReceivedGold(int id) {


        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UpdateReceivedGoldBadgesApi");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),id));
        TypedQuery<Employee> query=entityManager.createQuery(criteriaQuery);
        Employee employee=query.getSingleResult();


        employee.setReceivedGoldCount(employee.getReceivedGoldCount()+1);
        employee.setTotalGoldPoint(employee.getTotalGoldPoint()+30);
        entityManager.getTransaction().commit();

        return true;

    }

    //@Modifying
    public boolean updateReceivedSilver(int id) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UpdateReceivedGoldBadgesApi");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),id));
        TypedQuery<Employee> query=entityManager.createQuery(criteriaQuery);
        Employee employee=query.getSingleResult();


        employee.setReceivedGoldCount(employee.getReceivedSilverBadgeCount()+1);
        employee.setTotalSilverPoint(employee.getTotalSilverPoint()+20);
        entityManager.getTransaction().commit();

        return true;

    }
    //@Modifying
    public boolean updateReceivedBronze(int id) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UpdateReceivedGoldBadgesApi");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),id));
        TypedQuery<Employee> query=entityManager.createQuery(criteriaQuery);
        Employee employee=query.getSingleResult();


        employee.setReceivedBronzeBadgeCount(employee.getReceivedBronzeBadgeCount()+1);
        employee.setTotalBronzePoint(employee.getTotalBronzePoint()+10);
        entityManager.getTransaction().commit();

        return true;
    }





    public boolean updateRemainingGold(int id) {


        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UpdateReceivedGoldBadgesApi");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),id));
        TypedQuery<Employee> query=entityManager.createQuery(criteriaQuery);
        Employee employee=query.getSingleResult();


        int val = employee.getShareableGoldBadgeCount();
        if (val == 0)
            return false;
        employee.setShareableGoldBadgeCount(val - 1);
        entityManager.getTransaction().commit();

        return true;

    }

    //@Modifying
    public boolean updateRemainingSilver(int id) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UpdateReceivedGoldBadgesApi");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),id));
        TypedQuery<Employee> query=entityManager.createQuery(criteriaQuery);
        Employee employee=query.getSingleResult();


        int val = employee.getShareableSilverBadgeCount();
        if (val == 0)
            return false;
        employee.setShareableSilverBadgeCount(val - 1);
        entityManager.getTransaction().commit();

        return true;

    }
    //@Modifying
    public boolean updateRemainingBronze(int id) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("UpdateReceivedGoldBadgesApi");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);

        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("id"),id));
        TypedQuery<Employee> query=entityManager.createQuery(criteriaQuery);
        Employee employee=query.getSingleResult();


        int val = employee.getShareableBronzeBadgeCount();
        if (val == 0)
            return false;
        employee.setShareableBronzeBadgeCount(val - 1);
        entityManager.getTransaction().commit();

        return true;
    }

        public Employee  getReceivedBadgesOfEmployee(String email) throws ZeroBadgeException {
            Optional<Employee> employee=employeeRepository.findAllByEmail(email);
            Employee employee1=employee.orElse(null);
            if (employee1==null){
                throw new ZeroBadgeException();
            }
            return employee1;

        }

        public Employee getRemainingBadgesOfEmployee(String email) throws ZeroBadgeException {
            Optional<Employee> employee=employeeRepository.findAllByEmail(email);
            Employee employee1=employee.orElse(null);
            if (employee1==null){
                throw new ZeroBadgeException();
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

   public Employee findEmployeeById(Integer id) throws ZeroBadgeException {
        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employee1=employee.orElse(null);
        if (employee1==null){
            throw new ZeroBadgeException();
        }
        return employee1;
    }


    public void saveEmp(Employee employee){
        employeeRepository.save(employee);
    }
}

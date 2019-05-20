package com.ReapWebFinal.ReapWebFinal.repository;

import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

        Employee findByEmailAndPassword(String email,String password);
        Optional<Employee> findAllByEmail(String email);
        List<Employee> findByFirstnameContaining(String term);
        Optional<Employee> findByEmail(String email);



        //List<Employee> findAll();
}

package com.springdata.repositories;


import com.springdata.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.jws.Oneway;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Integer> {
    void delete(Person deleted);

    List<Person> findAll();

    Person save(Person persisted);

    Person findByFirstname(String name);
    Person findByLastname(String name);
    Person findByAge(Integer age);
    Person findBySalary(Integer salary);

    @Query("select firstname from Person where age=25")
    List<String> findByFirstname_25();

    @Query("select firstname, lastname from Person where age=25")
    List<Object[]> findByFisrtnameAndLastname();

    @Query("select p from Person p where p.age=25")
    List<Person> findPerson();

    @Query("SELECT count(p) from Person p where p.firstname='Peter'")
    Integer CountPerson_Peter();

    int countById();
    int countByFirstname();
    int countByLastname();
    Person countDistinctByFirstname(String name);
    List<Person> findByFisrtnameOrLastname(String firstname, String lastname);
    List<Person> findByFisrtnameAndLastname(String firstname, String lastname);
    List<Person>  findByAgeBetween(Integer i1, Integer i2);
    List<Person>  findByAgeLessThan(Integer i1);
    List<Person>  findByAgeGreaterThan(Integer i1);   //Can Be used By age > 25
    List<Person>  findByAgeLike(String name);
    List<Person>  findByFirstnameNot(String name);
    List<Person>  findByAgein(List<Integer> ageList);
    List<Person>  findByNameIgnoreCase(String name);

    /*Get the persons greater than age 25 and sort them in descending order according to id by method query.*/

    List<Person> findByAgeGreaterThanOrderByIdDesc(Integer age);

    List<Person> findByAgeGreaterThan(Integer age, Sort sort);

    Page<Person> findAll(Pageable pageable);



}

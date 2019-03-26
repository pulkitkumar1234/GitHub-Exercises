import com.springdata.config.PersistenceContext;
import com.springdata.entity.Person;
import com.springdata.repositories.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class main {
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(PersistenceContext.class);
        Person person=new Person();
        person.setSalary(15000);;
        person.setFisrtname("Pulkit");
        person.setLastname("Kumar");
        person.setAge(25);

        Person person2=new Person();
        person2.setSalary(15000);;
        person2.setFisrtname("Peter");
        person2.setLastname("Paul");
        person2.setAge(25);

        Person person3=new Person();
        person3.setSalary(15000);;
        person3.setFisrtname("Peter");
        person3.setLastname("Fernandis");
        person3.setAge(25);

        PersonRepository personRepository=context.getBean(PersonRepository.class);
        personRepository.save(person);
        personRepository.save(person2);
        personRepository.save(person3);

        /*System.out.println(personRepository.findByAge(27).toString());
        System.out.println(personRepository.findAll().toString());
        System.out.println(personRepository.findByFirstname("Pulkit").toString());
        System.out.println(personRepository.findByLastname("Kumar").toString());
        System.out.println(personRepository.findBySalary(15000).toString());
        System.out.println(personRepository.findByAge(25).toString());

        List<String> list=personRepository.findByFirstname_25();
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        personRepository.findByFisrtnameAndLastname().forEach(e-> System.out.println(Arrays.toString(e)));
        List<Person> list2=personRepository.findPerson();
        Iterator iterator2=list.iterator();
        while(iterator2.hasNext())
        {
            System.out.println(iterator2.next().toString());
        }
*/
        Integer i=personRepository.CountPerson_Peter();
        System.out.println("No of Person With Name 'Peter':="+i);

        //Question11
        personRepository.findByAgeGreaterThanOrderByIdDesc(25).forEach(System.out::println);

//        Question12
        personRepository.findByAgeGreaterThan(25, new Sort(Sort.Direction.DESC,"id")).forEach(System.out::println);

//        Question13
        Page<Person> personPage = personRepository.findAll(new PageRequest(0,2,new Sort(Sort.Direction.DESC,"id")));
        List<Person> personList3 = personPage.getContent();
        personList3.forEach(System.out::println);
    }
}

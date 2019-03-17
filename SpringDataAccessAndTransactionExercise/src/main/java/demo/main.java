package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springDAO.xml");
    /*    UserDAO userDAO = applicationContext.getBean(UserDAO.class);
        userDAO.printUserName();*/
        /*UserDAO2 userDAO2 = applicationContext.getBean(UserDAO2.class);
        userDAO2.printUserDetails();*/
        UserDAO3 userDAO3=applicationContext.getBean(UserDAO3.class);
        /*userDAO3.print();
        userDAO3.display();
        System.out.println(userDAO3.getUserName());
        userDAO3.QueryForMap();
        userDAO3.QueryForList();
        System.out.println(userDAO3.QueryMapper("raj"));

        userDAO3.sessionFactoryHibernate();*/
        userDAO3.insert();



    }
}
package SpringCoreExercises;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Configuration
public class Main {
    public static void main(String[] args) {
        //IOC Object Creation
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");

        DataBase dataBase=(DataBase) context.getBean("database");
        System.out.println(dataBase.getName());
        System.out.println(dataBase.getPort());


        Restaurent restaurent4=(Restaurent) context.getBean("teaRestaurant4") ;
        restaurent4.getHotDrink().prepareHotDrink();

        Restaurent restaurent=(Restaurent) context.getBean("teaRestaurant");
        restaurent.getHotDrink().prepareHotDrink();

        Restaurent restaurent1=(Restaurent) context.getBean("ExpressteaRestaurant");
        restaurent1.getHotDrink().prepareHotDrink();

        /*HotDrink hotDrink=(Tea) context.getBean("tea");
        hotDrink.prepareHotDrink();

        hotDrink=(ExpressTea) context.getBean("expressTea");
        hotDrink.prepareHotDrink();*/

        Complex complex=(Complex)context.getBean("complex");
        System.out.println(complex.getList());
        System.out.println(complex.getMap());
        System.out.println(complex.getSet());


        Restaurent restaurent2 = (Restaurent) context.getBean("teaRestaurant1");
        restaurent2.getHotDrink().prepareHotDrink();



        Restaurent restaurent3 = (Restaurent) context.getBean("teaRestaurant2");
        restaurent3.getHotDrink().prepareHotDrink();

        Restaurent restaurent5=(Restaurent) context.getBean("teaRestaurant2");
        restaurent5.getHotDrink().prepareHotDrink();

        System.out.println("Restaurent 5"+restaurent5.hashCode()+"   Restaurent 3"+restaurent3.hashCode());




    }
}

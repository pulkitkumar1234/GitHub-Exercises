package SpringAOPExeecise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@EnableAspectJAutoProxy
@Configuration
public class main {
    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("SpringAOP.xml");
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("SpringAOPExeecise");
      /* ctx.start();*/
        dummy1 dummy = (dummy1) ctx.getBean("dummy1");
        dummy.display();
    }
}

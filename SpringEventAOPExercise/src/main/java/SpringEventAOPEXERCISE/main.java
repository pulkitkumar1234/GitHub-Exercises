package SpringEventAOPEXERCISE;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("AopExercise.xml");
            ctx.start();
            ctx.refresh();
            Dummy dummy = ctx.getBean("dummy", Dummy.class);
            /*Publisher dummy = ctx.getBean("Publisher", Publisher.class);*/
            dummy.display();
            ctx.stop();
            ctx.close();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

package SpringEventAndAOP;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springEventAop.xml");
        ctx.start();
        dummy dummy = ctx.getBean("dummy", dummy.class);
        dummy.display();
        ctx.stop();
    }
}

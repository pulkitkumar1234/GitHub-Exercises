package SpringEventAOPEXERCISE2;

import SpringAOPExeecise.dummy1;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("SpringEventAOPEXERCISE2");
        ctx.start();
        Service dummy = ctx.getBean(Service.class);
        dummy.display();
        Integer int1 = dummy.getInterger(10);
        dummy.throwException();
        ctx.stop();
        ctx.close();

    }
}

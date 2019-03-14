package SpringEventAOPEXERCISE;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class SpringEventListener implements ApplicationListener <ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.getSource());
    }
}






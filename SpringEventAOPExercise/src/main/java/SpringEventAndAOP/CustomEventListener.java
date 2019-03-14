package SpringEventAndAOP;


import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<customEvent> {
    @Override
    public void onApplicationEvent(customEvent event) {
        System.out.println(event.getSource());
    }
}


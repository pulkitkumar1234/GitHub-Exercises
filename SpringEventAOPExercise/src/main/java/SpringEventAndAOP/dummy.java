package SpringEventAndAOP;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class dummy implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    void display() {


        customEvent customEvent = new customEvent(this);

        applicationEventPublisher.publishEvent(customEvent);

        System.out.println("Display");
    }

    @Override   //setter method for applicationEventPublisher
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

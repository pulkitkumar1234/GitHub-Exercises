package SpringEventAOPEXERCISE;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Publisher implements ApplicationEventPublisherAware {
    ApplicationEventPublisher applicationEventPublisher;
    void display() {
        MyEvent myEvent = new MyEvent(this);
        applicationEventPublisher.publishEvent(myEvent);
        System.out.println("Display on Event");
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    } }

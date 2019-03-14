package SpringEventAndAOP;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MultipleEventListener {
    @EventListener(ContextStartedEvent.class)
    @Async
    void start(){
        try {

        }catch (Exception e){
            System.out.println("Exception Ocurred!");
        }
        System.out.println("---------start");
    }
    @EventListener(ContextStoppedEvent.class)
    void stopped(){
        System.out.println("--------stopped");
    }

}

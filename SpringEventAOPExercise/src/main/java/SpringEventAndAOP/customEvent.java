package SpringEventAndAOP;

import org.springframework.context.ApplicationEvent;

public class customEvent extends ApplicationEvent {


    customEvent(Object object) {

        super(object);
    }
}
package SpringEventAOPEXERCISE;
import org.springframework.context.ApplicationEvent;


public class MyEvent extends ApplicationEvent {
    MyEvent(Object object) {
        super(object);
    }
}





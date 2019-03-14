package SpringEventAOPEXERCISE2;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("Service")
public class Service {


    public void display(){
        System.out.println("Service class display method");
    }

    public Integer getInterger(Integer integer){
        return integer;
    }

    public void throwException(){
        try {
            throw new IOException("This Exception");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}

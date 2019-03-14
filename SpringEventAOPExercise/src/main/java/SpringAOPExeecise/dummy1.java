package SpringAOPExeecise;

import SpringCoreExercises.ExpressTea;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class dummy1 {

    @Loggable
    public void display(){
        System.out.println("dummy class display method");
    }

    public Integer getInterger(){
        return 10;
    }

    public Exception throwException(){
        throw  new RuntimeException("This Exception");
    }
}

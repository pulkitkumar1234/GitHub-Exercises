package SpringCoreExercises;

import org.springframework.stereotype.Component;

@Component
public class ExpressTea implements HotDrink {

    public ExpressTea() {
    }

    public void prepareHotDrink(){
        System.out.println("Drink Type: EXPRESS TEA");

    }
}

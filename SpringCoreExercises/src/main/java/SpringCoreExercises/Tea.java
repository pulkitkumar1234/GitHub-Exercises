package SpringCoreExercises;

import org.springframework.stereotype.Component;

@Component
public class Tea implements HotDrink {

    public Tea() {

    }


    public void prepareHotDrink(){
        System.out.println("Drink Type: TEA");
    }
}

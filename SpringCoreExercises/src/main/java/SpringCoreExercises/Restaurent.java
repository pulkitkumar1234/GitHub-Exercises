package SpringCoreExercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Restaurent {

    HotDrink hotDrink;

    public Restaurent(HotDrink hotDrink, Tea tea){
        this.hotDrink=hotDrink;
        this.tea=tea;
    }

    @Autowired
    Tea tea;

    @Autowired
    public Restaurent(Tea tea) {
        this.tea = tea;
    }

    public Tea getTea() {
        return tea;
    }

    @Autowired
    public void setTea(Tea tea) {
        this.tea = tea;
    }

    public HotDrink getHotDrink() {
        return hotDrink;
    }
    @Required
    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }
    public Restaurent() {

    }

    public Restaurent(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }
    @Override
    public String toString(){
        return "This is Restaurent";
    }
}

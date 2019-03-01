import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;
public class Fifth {
    public static void main(String[] args) {

        Consumer<Integer> consumer=(consumedValue)-> System.out.println(consumedValue);
        consumer.accept(100);

        Supplier<Integer> supplier=()->new Integer((int)(Math.random()*500));
        System.out.println(supplier.get());

        List<Integer> list= Arrays.asList(1,null, 3,null,5,7,9,null);
        Predicate<Integer> predicate=(values)->values!=null;
        list.stream().filter(predicate).forEach(System.out::println);

        Function<Integer, Integer> function= (functionValue)->functionValue+1;
        System.out.println(function.apply(10));
    }
}

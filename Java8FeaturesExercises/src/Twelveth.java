import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Twelveth{


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> integer=list.stream().filter(e->e>3).filter(e->e%2==0).findFirst();

        if(integer.isPresent())
            System.out.println("First Even Value Greater Than 3 :: "+integer.get());
    }

}


import java.util.*;
import java.util.Arrays;

public class Tenth {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum=list.stream().filter(e->e>5).reduce(0,(a,b)->a+b);
        System.out.println("Sum Of Number Greater Than 5::"+sum);
    }

}


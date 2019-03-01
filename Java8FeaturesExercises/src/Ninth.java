import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ninth {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.stream().filter(e->e%2==0).forEach(System.out::print);
    }

}

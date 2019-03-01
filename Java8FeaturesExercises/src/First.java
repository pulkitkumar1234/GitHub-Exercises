@FunctionalInterface
interface CalculateGreater {
    boolean greater(int a, int b);
}

@FunctionalInterface
interface IncrementInteger {
    int AddOne(int a);
}

@FunctionalInterface
interface ConcateString {
    String con(String s1, String s2);
}

@FunctionalInterface
interface Upper {
    String up(String s);
}

class Manipulation {
    public static void main(String[] args) {

        /*Find Greater Integer*/
        CalculateGreater calc = (a, b) -> {
            if (a > b)
                return true;
            else
                return false;

        };

        boolean result = calc.greater(5, 10);
        System.out.println(result);


        /*Increment Integer*/
        IncrementInteger inc = (a) -> {
            return a++;
        };

        int result2 = inc.AddOne(5);
        System.out.println(result2);

        /*Concat String Values*/
        ConcateString con = (a, b) -> {
            a = a.concat(b);
            return a;

        };

        String result3 = con.con("Pulkit ", "Kumar");
        System.out.println(result3);

        /*Conver String To UpperCase*/
        Upper up = (a) -> a.toUpperCase();
        System.out.println(up.up("text in uppercase"));
    }


}

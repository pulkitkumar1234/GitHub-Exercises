public class Seventh {

    static String FirstName = "Pulkit";
    static String LastName = "Kumar";
    static int Age = 24;

    public static void main(String[] args) {
        System.out.println("Using Static Variable:");
        System.out.println(Seventh.FirstName);
        System.out.println(Seventh.LastName);
        System.out.println(Seventh.Age);
        Seventh.print();
    }

    static void print() {
        System.out.println("In Static Method FirstName:" + FirstName + " " + "LastName:" + LastName + " " + "Age:" + Age);
    }

    static {
        System.out.println("IN Static Block FirstName:" + FirstName + " " + "LastName:" + LastName + " " + "Age:" + Age);
    }


}

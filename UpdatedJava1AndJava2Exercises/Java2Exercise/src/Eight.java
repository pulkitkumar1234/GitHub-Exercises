import java.util.*;

public class Eight {

    String string;

    public void CharMatchWHile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String to match");
        string = sc.next();
        string = string.trim();
        if (string.isEmpty()) {
            System.out.println("No String Found!");
        } else {
            while (!string.equals("done")) {
                if (string.charAt(0) == string.charAt(string.length() - 1)) {
                    System.out.println("First and last character are equals of String: " + string);
                } else {
                    System.out.println("First and last character are NOT equals of String: " + string);
                }
                string = sc.next();
            }
        }

    }

    public void CharMatchDoWhile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String string = sc.next();
        string = string.trim();
        if (string.isEmpty()) {
            System.out.println("No String Found!");
        } else {
            do {
                if (string.charAt(0) == string.charAt(string.length() - 1)) {
                    System.out.println("First and last character are equals for the String: " + string);
                } else {
                    System.out.println("First and last character are NOT equals for the String: " + string);
                }
                string = sc.next();
            } while (!string.equals("done"));
        }

    }

    public static void main(String[] args) {

        Eight obj = new Eight();
        obj.CharMatchWHile();
        obj.CharMatchDoWhile();
    }

}

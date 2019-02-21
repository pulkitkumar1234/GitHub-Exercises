import java.util.*;
public class Eight {

    String str;
    public void CharMatchWHile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String to match");
        str = sc.next();
        while(!str.equals("done")) {
            if(str.charAt(0) == str.charAt(str.length() - 1))
            {
                System.out.println("First and last character are equals of String: " + str);
            }
            else {
                System.out.println("First and last character are NOT equals of String: " + str);
            }
            str = sc.next();
        }
    }

    public void CharMatchDoWhile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = sc.next();
        do { if(str.charAt(0) == str.charAt(str.length() - 1)) {
            System.out.println("First and last character are equals for the String: " + str);
        } else {
            System.out.println("First and last character are NOT equals for the String: " + str);
        }
        str = sc.next();
        }while(!str.equals("done"));
    }

    public static void main(String[] args) {

        Eight e1=new Eight();
        e1.CharMatchWHile();
        e1.CharMatchDoWhile();
    }

}

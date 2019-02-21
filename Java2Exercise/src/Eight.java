import java.util.*;
public class Eight {

    String str;
    public void CharMatch(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a String to match");
        str = keyboard.next();
        while(!str.equals("done")) {
            if(str.charAt(0) == str.charAt(str.length() - 1))
            {
                System.out.println("First and last character are equals of String: " + str);
            }
            else {
                System.out.println("First and last character are NOT equals of String: " + str);
            }
            str = keyboard.next();
        }
    }

    public static void main(String[] args) {

        Eight e1=new Eight();
        e1.CharMatch();
    }

}

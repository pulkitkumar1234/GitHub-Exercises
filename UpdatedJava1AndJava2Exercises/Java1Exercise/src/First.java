import java.util.*;

class First {
    private String stringRead;
    private String stringReplace;
    private String stringInsert;

    public static void main(String[] args) {
        First obj = new First();
        obj.InputValue();
    }

    public void InputValue() {
        System.out.println("Enter the String Value");
        Scanner sc = new Scanner(System.in);
        stringRead = sc.nextLine();
        stringRead = stringRead.trim().toUpperCase();
        if (stringRead.isEmpty()) {
            System.out.println("No String Available");
        } else if (stringRead.isBlank()) {
            System.out.println("No String Available");
        } else {
            System.out.println("Enter What you Want to Replace:");
            stringReplace = sc.nextLine();
            stringReplace = stringReplace.trim().toUpperCase();
            if (stringReplace.isEmpty()) {
                System.out.println("No String Available");
            } else if (stringReplace.isBlank()) {
                System.out.println("No String Available");
            } else {
                if (stringRead.contains(stringReplace)) {
                    System.out.println("Enter With Which String You Want to Replace:");
                    String strigInsert = sc.nextLine();
                    stringInsert = strigInsert.trim().toUpperCase();
                    this.StrReplace(stringRead, stringReplace, stringInsert);
                } else {
                    System.out.println("String Value Entered do not exist");
                }
            }
        }
    }

    private String string;

    public void StrReplace(String stringRead, String stringReplace, String stringInsert) {
        string = stringRead;
        string = string.trim().toUpperCase();
        System.out.println("Older String:" + string.toLowerCase());
        string = string.replace(stringReplace, stringInsert);
        System.out.println(string);
    }


}
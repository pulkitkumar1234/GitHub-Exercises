import java.util.Scanner;

public class Eight {

    private StringBuffer stringbuffer = new StringBuffer();
    private String string;

    public static void main(String[] args) {
        Eight obj = new Eight();
        obj.reverseFunction();
    }

    public void reverseFunction() {
        System.out.println("Enter String To Reverse:");
        Scanner sc = new Scanner(System.in);
        string = sc.nextLine();
        for (int i = string.length() - 1; i >= 0; i--) {
            stringbuffer.append(string.charAt(i));
        }
        System.out.println("Reversed String:" + stringbuffer);
        stringbuffer.delete(4, 9);
        System.out.println("Reversed String After Removal of letter from 4 to 9 index");
        System.out.println("Reversed String:" + stringbuffer);
    }
}

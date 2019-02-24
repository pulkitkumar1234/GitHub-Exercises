import java.util.Scanner;

public class Second {

    private String string;

    public void getString() {
        char temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String Value");
        string = sc.nextLine();
        string=string.trim();
        if(string.isEmpty()){
            System.out.println("No String Found!");
        }else {
            sc.close();
            this.sorted(string);
        }

    }

    public void sorted(String string) {
        char temp;
        char[] chArry = string.toCharArray();
        for (int i = 0; i < chArry.length; i++) {
            for (int j = i + 1; j < chArry.length; j++) {
                if (chArry[i] > chArry[j]) {
                    temp = chArry[i];
                    chArry[i] = chArry[j];
                    chArry[j] = temp;
                }
            }
        }
        String SortString = "";
        for (int k = 0; k < chArry.length; k++) {
            SortString = SortString + chArry[k];
        }
        System.out.println("Sorted String:" + SortString);
    }


    public static void main(String[] args) {
        Second obj = new Second();
        obj.getString();

    }
}

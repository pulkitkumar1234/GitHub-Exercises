import java.util.Scanner;

class Second {

    public static void main(String[] args) {

        Second obj = new Second();
        obj.InputValue();

    }
    public void InputValue() {

        System.out.println("Enter String Having Repeated Words:");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        if (string.isBlank()) {
            System.out.println("No String Available");
        }
        else if(string.isEmpty()){
            System.out.println("No String Available");
        }
        else {
            string = (string.trim()).toUpperCase();
            this.ReplaceRepeatedString(string);

        }
    }


    public void ReplaceRepeatedString(String string) {
        String[] StringArray = string.split(" ");
        int wordCount = 1;
        for (int i = 0; i < StringArray.length; i++) {
            for (int j = i + 1; j < StringArray.length; j++) {
                if (StringArray[i].equals(StringArray[j])) {
                    wordCount += 1;
                    StringArray[j] = "0";
                }
            }
            if (StringArray[i] != "0") {
                System.out.println(StringArray[i].toLowerCase() + " " + wordCount);
            }
            wordCount = 1;
        }
    }



}

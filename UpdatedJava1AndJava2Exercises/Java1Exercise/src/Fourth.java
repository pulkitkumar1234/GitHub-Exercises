public class Fourth {
    private String string;

    public static void main(String[] args) {

        Fourth obj = new Fourth("My Name is Pulkit I Am MCA Student Pj.pulkit241@gmail.com 12/12/12");
        obj.calculatePercentage();

    }

    public Fourth(String str) {
        this.string = str;
    }

    public void calculatePercentage() {

        int lenghth1 = this.string.length();
        int uppercaseLetter = 0;
        int LowercaseLetter = 0;
        int NumberType = 0;
        int SpecialCharacter = 0;

        for (int i = 0; i < lenghth1; i++) {
            char c = string.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercaseLetter++;
            } else if (Character.isLowerCase(c)) {
                LowercaseLetter++;
            } else if (Character.isDigit(c)) {
                NumberType++;
            } else {
                SpecialCharacter++;
            }
        }


        double Up = (uppercaseLetter * 100) / lenghth1;
        double lw = (LowercaseLetter * 100) / lenghth1;
        double num = (NumberType * 100) / lenghth1;
        double spe = (SpecialCharacter * 100) / lenghth1;


        System.out.println("Percentage of UpperCase Letter:" + Up + "%");
        System.out.println("Count Of Uppercase Letter:" + uppercaseLetter);

        System.out.println("Percentage of LowerCase Letter:" + lw + "%");
        System.out.println("Count Of LowerCase Letter:" + LowercaseLetter);

        System.out.println("Percentage of NumType Letter:" + num + "%");
        System.out.println("Count Of NumType Letter:" + NumberType);

        System.out.println("Percentage of Special Letter:" + spe + "%");
        System.out.println("Count Of Special Letter:" + SpecialCharacter);
    }


}

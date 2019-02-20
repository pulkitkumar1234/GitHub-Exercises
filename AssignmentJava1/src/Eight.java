import java.util.Scanner;

public class Eight {

    private StringBuffer sb=new StringBuffer();
    private String str;
    public void reverseFun()
    {
        System.out.println("Enter String To Reverse:");
        Scanner sc =new Scanner(System.in);
        str=sc.nextLine();
        for(int i = str.length() - 1; i >= 0; i--)
        {
            sb.append(str.charAt(i));
        }
        System.out.println("Reversed String:"+sb);
        sb.delete(4,9);
        System.out.println("Reversed String After Removal of letter from 4 to 9 index");
        System.out.println("Reversed String:"+sb);


    }

    public static void main(String [] args)
    {
        Eight e1=new Eight();
        e1.reverseFun();
    }
}

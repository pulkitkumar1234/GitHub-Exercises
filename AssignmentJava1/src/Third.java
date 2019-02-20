import java.util.*;
public class Third {

    String str;

public void inp(){
    System.out.println("Enter String:");
    Scanner sc=new Scanner(System.in);
    str=sc.nextLine();
    this.ReplaceCount(str);

}

public void ReplaceCount(String str)
{
    int l=str.length();
    System.out.println("String Length before and replacement of Repeated word:"+ l);
    System.out.println("Enter Character You want to replace:");
    Scanner sc = new Scanner(System.in);
    String c=sc.next();
    int l1=str.replace(c,"").length();
    int l2=l-l1;
    System.out.println("No, of Occurance of Entered Charater:");
    System.out.println(l2);
}



    public static void main(String[] args) {
        Third t1=new Third();
        t1.inp();






       /* String str="This is my Third Java Program";
        System.out.println("String is:  "+ str);
        int l=str.length();
        System.out.println("String Length before and replacement of Repeated word:"+ l);
        System.out.println("Enter Character You want to replace:");
        Scanner sc = new Scanner(System.in);
        String c=sc.next();
        int l1=str.replace(c,"").length();
        int l2=l-l1;
        System.out.println("No, of Occurance of Entered Charater:");
        System.out.println(l2);*/
    }
}

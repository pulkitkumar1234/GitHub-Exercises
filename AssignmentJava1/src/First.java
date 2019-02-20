import java.util.*;
class First{

    private String str;

    public void StrReplace(String s, String s1, String s2)
    {
        str=s;
        System.out.println("Older String:"+str);
        System.out.println(str.replace(s1,s2));
    }

    public void inp(){
        System.out.println("Enter the String Value");
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        System.out.println("Enter What you Want to Replace:");
        String s1=sc.nextLine();
        System.out.println("Enter With Which String You Want to Replace:");
        String s2=sc.nextLine();
        this.StrReplace(st,s1,s2);
    }

    public static void main(String[] args) {
       First f1=new First();
        f1.inp();
    }
}
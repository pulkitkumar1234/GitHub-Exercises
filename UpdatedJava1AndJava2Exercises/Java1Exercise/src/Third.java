import java.util.*;
public class Third {

    String string;

public void InputValue(){
    System.out.println("Enter String:");
    Scanner sc=new Scanner(System.in);
    string=sc.nextLine();
    if(string.isBlank()|| string.isEmpty()){
        System.out.println("No String Entered");
    }
    else{
        string=string.trim().toUpperCase();
        this.ReplaceCount(string);
    }


}

public void ReplaceCount(String string)
{
    int length=string.length();
    System.out.println("String Length before and replacement of Repeated word:"+ length);
    System.out.println("Enter Character You want to replace:");
    Scanner sc = new Scanner(System.in);
    String character=sc.next().toUpperCase();

     if(character.isEmpty()){
        System.out.println("NO Character Available");
    }
     else if(character.isBlank()){
         System.out.println("NO Character Available");
     }
   else if(character.length() > 1){
        System.out.println("More than one character entered.");
    }
    else{
        int length1=string.replace(character,"").length();
        int length2=length-length1;
        System.out.println("No, of Occurance of Entered Charater:"+character.toLowerCase());
        System.out.println(length2);
    }

}
    public static void main(String[] args) {
        Third Obj=new Third();
        Obj.InputValue();
    }
}

import java.util.Scanner;

public class Second {

    //String str;

//public Second(String s){
  //  str=s;
//}

public void rep(String str)
{
    String[] Sarr=str.split(" ");
    int wc=1;
    for (int i=0;i<Sarr.length;i++){
        for(int j=i+1;j<Sarr.length;j++){
            if(Sarr[i].equals(Sarr[j])){
                wc+=1;
                //System.out.println(Sarr[i]);
                Sarr[j]="0";
            }

        }
        if(Sarr[i]!="0"){
            System.out.println(Sarr[i]+" "+wc);
        }
        wc=1;
    }
}

public  void inp(){

    System.out.println("Enter String Having Repeated Words:");
    Scanner sc=new Scanner(System.in);
    String st=sc.nextLine();
    this.rep(st);

}

    public static void main(String[] args) {

        Second s1=new Second();
        s1.inp();

    }
}

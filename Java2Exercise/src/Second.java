import java.util.Scanner;
public class Second{
    public void getString()
    {
        char temp;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String Value");
        String str= sc.nextLine();
        sc.close();
        this.sorted(str);

    }

    public void sorted(String str)
    {
        char temp;
        char[] chArry=str.toCharArray();
        for(int i=0;i<chArry.length;i++){
            for(int j=i+1;j<chArry.length;j++){
                if(chArry[i]>chArry[j])
                {
                    temp=chArry[i];
                    chArry[i]=chArry[j];
                    chArry[j]=temp;
                }
            }
        }
        String SortString="";
        for(int k=0;k<chArry.length;k++){
            SortString=SortString+chArry[k];
        }
        System.out.println("Sorted String:"+SortString);
    }



    public static void main(String[] args) {
        Second f1=new Second();
        f1.getString();

    }
}

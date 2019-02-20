public class Fourth {
    String str;

    public Fourth(String str)
    {
        this.str=str;
    }

    public void cal(){

        int l1= this.str.length();
        int uPCL=0;
        int lWCL=0;
        int numType=0;
        int Spec=0;

        for(int i=0;i<l1;i++)
        {
            char c=str.charAt(i);
            if(Character.isUpperCase(c))
            {
                uPCL++;
            }
            else if(Character.isLowerCase(c)){
                lWCL++;
            }
            else if(Character.isDigit(c)){
                numType++;
            }
            else{
                Spec++;
            }
        }


        double Up=(uPCL*100)/l1;
        double lw=(lWCL*100)/l1;
        double num=(numType*100)/l1;
        double spe=(Spec*100)/l1;


        System.out.println("Percentage of UpperCase Letter:"+Up+"%");
        System.out.println("Count Of Uppercase Letter:"+uPCL);

        System.out.println("Percentage of LowerCase Letter:"+lw+"%");
        System.out.println("Count Of LowerCase Letter:"+lWCL);

        System.out.println("Percentage of NumType Letter:"+num+"%");
        System.out.println("Count Of NumType Letter:"+numType);

        System.out.println("Percentage of Special Letter:"+spe+"%");
        System.out.println("Count Of Special Letter:"+Spec);
    }


    public static void main(String[] args) {

        Fourth f1=new Fourth("My Name is Pulkit I Am MCA Student Pj.pulkit241@gmail.com 12/12/12");
        f1.cal();

        }


}

public class Eleventh {

    private String BankName;
    private String Branch;
    private int ROI;
    public static void main(String[] args) {
        SBI sbi=new SBI();
        sbi.setDetails("State Bank of India","Janakpuri",10);
        sbi.getDetails();


        BOI boi=new BOI();
        boi.setDetails("BOI","Tilak Nagar",7);
        boi.getDetails();

        ICICI ic=new ICICI();
        ic.setDetails("ICICI","Noida",20);
        ic.getDetails();


        Eleventh e=new SBI();
        e.setDetails("SBI","Janakpuri",12);
        e.getDetails();


    }

    public void  getDetails(){
        System.out.println(BankName);
        System.out.println(Branch);
        System.out.println(ROI);
    }
    public void  setDetails(String BN, String Br, int R)
    {
        BankName=BN;
        Branch=Br;
        ROI=R;
    }

}

class SBI extends Eleventh{

    @Override
    public void getDetails()
    {
        System.out.println("SBI Details");
        super.getDetails();
    }
    @Override
    public void setDetails(String BN, String Br, int R)
    {
        System.out.println("This is SBI");
        super.setDetails(BN,Br,R);
    }

}

class BOI extends Eleventh{
    @Override
    public void getDetails()
    {
        System.out.println("BOI Details");
        super.getDetails();
    }
    @Override
    public void setDetails(String BN, String Br, int R)
    {
        System.out.println("This is BOI");
        super.setDetails(BN,Br,R);
    }

}

class ICICI extends Eleventh{

    @Override
     public void getDetails()
    {
        System.out.println("ICICI Details");
        super.getDetails();
    }
    @Override
    public void setDetails(String BN, String Br, int R)
    {
        System.out.println("This is ICICI");
        super.setDetails(BN,Br,R);
    }

}

import java.text.SimpleDateFormat;
import java.util.Date;

public class Question9 {
    
    public static void main(String[] args) {
    
        Date D=new Date();
        SimpleDateFormat SDF;
        
        SDF=new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("YMD: "+SDF.format(D));
        
        SDF=new SimpleDateFormat("dd-MM-YYYY");
        System.out.println("DMY: "+SDF.format(D));
    
        SDF=new SimpleDateFormat("MM-dd-YYYY");
        System.out.println("MDY: "+SDF.format(D));
        
        
    }
    
}

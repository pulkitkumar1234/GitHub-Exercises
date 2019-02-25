import java.text.SimpleDateFormat;
import java.util.Date;

class Eight{
    public static void main(String[] args) {
        String pattern="dd-MMMM-yyy";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        String date=simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
public class Tenth {

    public void calc(int i1,int i2){
        System.out.println(i1+i2);

    }
    public void calc(double d1, double d2){
        System.out.println(d1+d2);
    }

    public void calc1(float f1,float f2){
        System.out.println(f1*f2);
    }

    public void calc1(int it1, int it){
        System.out.println(it1*it);
    }

    public void calc2(String s1, String s2){
        System.out.println(s1.concat(s2));
    }

    public void calc2(String s1, String s2, String s3){
        System.out.println(s1.concat(s2.concat(s3)));
    }

    public static void main(String[] args) {
        Tenth th=new Tenth();
        th.calc(1,2);
        th.calc(20.11f,10.11f);
        th.calc1(10.0f,20.0f);
        th.calc1(1,2);
        th.calc2("String1","String 2");
        th.calc2("String1","String2","String3");
    }
}

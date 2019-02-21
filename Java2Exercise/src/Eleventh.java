class Eleventh{
    public void func(){
        int s = 0;
        int t = 1;
        int i=0;
        while(i<10)
        /*for (int i = 0; i < 10; i++)*/
        {
            s = s + i;
            int j=i;
            while(j>0)
            /*for (int j = i; j > 0; j--)*/
            {
                t = t * (j - i);
                j--;
            }
            s = s * t;
            System.out.println("T is " + t);

            i++;
        }
        System.out.println("S is " + s);
    }

    public static void main(String[] args) {
        Eleventh e1=new Eleventh();
        e1.func();
    }
}




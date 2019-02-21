class Sixth {
    private int d;
    private int n;
    private int fraction;

    public void excep() {
        try {
            d = 1;
            n = 20;
            fraction = n / d;
            int g[] = {1};
            g[20] = 100;
        } catch (ArithmeticException e) {
            System.out.println("In the catch clock due to Exception = " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("In the catch clock due to Exception = " + e);
        }finally {
            System.out.println("InThe Finally Block, Always Executed");
        }
    }

    public static void main(String args[]) {

        Sixth s1=new Sixth();
        s1.excep();

    }
}
class Sixth {
    private int denominator;
    private int numerator;
    private int fraction;

    public void Exception() {
        try {
            denominator = 1;
            numerator = 20;
            fraction = numerator / denominator;
            int g[] = {1};
            g[20] = 100;
        } catch (ArithmeticException e) {
            System.out.println("In the catch clock due to Exception = " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("In the catch clock due to Exception = " + e);
        } finally {
            System.out.println("In The Finally Block, Always Executed");
        }
    }

    public static void main(String args[]) {

        Sixth obj = new Sixth();
        obj.Exception();

    }
}
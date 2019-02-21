class copy {

    private double num1, num2;

    public copy(double n1, double n2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    copy(copy c) {
        System.out.println("Copy constructor called");
        num1 = c.num1;
        num2 = c.num2;
    }

    @Override
    public String toString() {
        return "(" + num1 + " + " + num2 + "i)";
    }



    public static void main(String[] args) {
        copy c1 = new copy(10, 15);

        copy c2 = new copy(c1);

        copy c3 = c2;

        System.out.println(c2);
    }
}




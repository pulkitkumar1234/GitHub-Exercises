class A {
    // some code

}

class Third {

    public static void main(String[] args) {
        Third sc = new Third();
        sc.ClassnotFoundFun();


    }

    public void ClassnotFoundFun() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            A a = new A();
        }
    }


}



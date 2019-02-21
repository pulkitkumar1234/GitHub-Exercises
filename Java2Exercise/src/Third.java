public class Third {

    public void ClassnotFoundFun()
    {
        try

        {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        }catch (ClassNotFoundException e)

        {

            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        Third sc=new Third();
        sc.ClassnotFoundFun();

        A a = new A();
    }
}
class A

{

    // some code

}


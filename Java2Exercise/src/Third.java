class A

{

    // some code

}
public class Third {

    public void ClassnotFoundFun()
    {
        try

        {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        }catch (ClassNotFoundException e)

        {

            e.printStackTrace();

        }finally {
            A a = new A();
        }
    }

    public static void main(String[] args) {
        Third sc=new Third();
        sc.ClassnotFoundFun();


    }
}



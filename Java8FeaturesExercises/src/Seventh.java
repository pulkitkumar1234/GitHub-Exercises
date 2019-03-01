@FunctionalInterface
interface Print{
    void PrintName();
    default void PrintEmployee(){
        System.out.println("Default in Inteface!");
    }
}
class Implemanation implements Print{

    @Override
    public void PrintName(){
        System.out.println("This is Implemented Class");
    }
    @Override
    public void PrintEmployee(){
        System.out.println("This is Implemented default Method");
    }

  /*  @Override
    public String toString() {
        return
    }*/

    public static void main(String[] args) {
        Implemanation implemanation=new Implemanation();
        implemanation.PrintName();
        implemanation.PrintEmployee();

    }
}
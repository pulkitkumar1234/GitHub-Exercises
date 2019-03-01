@FunctionalInterface
interface DetailsPrinter{
    void Details();
    default void PrintName(String Name){
        System.out.println("Name is::"+ Name);
    }
    static void Designation(){
        System.out.println("Designation::Trainee!");
    }

}
class sixth implements DetailsPrinter{
    @Override
    public void Details(){
        System.out.println("Detail Are:");
    }

        public static void main(String[] args) {
        sixth obj=new sixth();
        obj.Details();
        obj.PrintName("Pulkit Kumar");
        DetailsPrinter.Designation();



    }
}
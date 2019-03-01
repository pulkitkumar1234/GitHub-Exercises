@FunctionalInterface
interface AdditionInteface{
    int summation(int a, int b);
}
@FunctionalInterface
interface SubstractionInterface{
    int substraction(int a, int b);
}
class Addition implements AdditionInteface{
    @Override
   public int summation(int a, int b){
        return a+b;
    }
}
class Substraction implements SubstractionInterface{
    @Override
    public int substraction(int a, int b){
        return a-b;
    }
}
@FunctionalInterface
interface MultiplicationInterface {
    int Multiplication(int a, int b);
}

class Calculation{

    static int Multiplication(int a, int b){
        return a*b;
    }

    public static void main(String[] args) {
        /*AdditionInteface additionInteface=(number1,number2)->{return  number1+number2;};
        SubstractionInterface substractionInterface=(number1,number2)->{return number1-number2;};*/
        Addition addition=new Addition();
        Substraction substraction=new Substraction();

        AdditionInteface additionInteface1=addition::summation;
        System.out.println("ADDITION:"+additionInteface1.summation(10,20));

        SubstractionInterface substractionInterface=substraction::substraction;
        System.out.println("SUBSTRACTION:"+substractionInterface.substraction(20,10));

        MultiplicationInterface multiplicationInterface=Calculation::Multiplication;
        System.out.println("MULTIPLICATION:"+multiplicationInterface.Multiplication(10, 20));
    }
}
@FunctionalInterface
interface ReturnOneValue{
    int sum (int Intal1,int IntVal2);
}
class ReturnOneInteger{
    public static void main(String[] args) {
        ReturnOneValue returnOneValue = (a,b) -> {
            return a+b;
        };
        System.out.println(returnOneValue.sum(10,20));
    }
}
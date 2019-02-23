class test{
    public static void main(String[] args) {
        int a=1;
        int b=0;
        try{
            int c=a/b;
            System.out.println("Line After");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("In Finally");
        }
        System.out.println("After Catch");
    }

}
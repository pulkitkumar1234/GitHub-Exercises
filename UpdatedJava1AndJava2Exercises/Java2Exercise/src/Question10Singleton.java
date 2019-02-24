import java.util.*;

class Question10 {
    private static Question10 st = new Question10();
    private static int token_number=1001;
    private double order_amount;
    private boolean token_status;
    private  boolean payment_status;
    private int[] order_queue;
    private int[] ready_queue;
    private final int MAX_ORDER;
    private Scanner In;
    private static int o_count;
    
    
    public Question10() {
        MAX_ORDER=10;
        token_status=false;
        payment_status=false;
        order_queue=new int[MAX_ORDER];
        ready_queue=new int[MAX_ORDER];
        In=new Scanner(System.in);
    }
    
    
    public static Question10 getInstance() {
        return st;
    }
    
    public int requestService() {
        System.out.println("[Pay Bill] Enter amount: ");
        order_amount=In.nextLong();
        if(order_amount>=0) {
            order_queue[o_count]=token_number;
            o_count++;
            token_number++;
            System.out.println("Order id "+token_number+" is in order queue, please wait.");
            
            return  token_number;
        } else {
            System.out.println("Amount not paid, try again.");
            return 0;
        }
    }
    
    public void processOrder() {
        if(order_queue.length>0) {
            for(int i=0;i<order_queue.length;i++) {
                if(order_queue[i]==0) {
                    break;
                } else {
                    System.out.println("Order id " + order_queue[i] + " is ready.");
                    ready_queue[i] = order_queue[i];
                }
            }
            order_queue=null;
        }
    }
    
    public void deliverService() {
        if(ready_queue.length>0) {
            for(int i=0;i<ready_queue.length;i++) {
                if(ready_queue[i]==0) {
                    break;
                } else {
                    System.out.println("Order id " + ready_queue[i] + " is completed.");
                }
            }
            ready_queue=null;
        }
    }
    
}

class myMain{

    public static void main(String[] args) {

        Question10 Q10=Question10.getInstance();
        int tNumber=Q10.requestService();
        System.out.println("Your token number(order number) is: "+tNumber);

        Question10 Q101=Question10.getInstance();
        int tNumber2=Q101.requestService();
        System.out.println("Your token number(order number) is: "+tNumber2);

        Q10.processOrder();
        Q101.processOrder();
        Q10.deliverService();

        Question10 Q102=Question10.getInstance();
        int tNumber3=Q101.requestService();
        System.out.println("Your token number(order number) is: "+tNumber3);
        Q10.processOrder();


        Q101.deliverService();
        Q10.deliverService();
    }



}
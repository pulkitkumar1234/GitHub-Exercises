class WaitandNotify {

    public void process1() {
        synchronized (this) {
            System.out.println("Thread "+Thread.currentThread().getName()+" Start");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+Thread.currentThread().getName()+" End");
        }
    }


    public void process2() {
        synchronized (this) {
            System.out.println("Thread "+Thread.currentThread().getName()+" Start");
            System.out.println("Thread "+Thread.currentThread().getName()+" End");
            notify();
        }
    }
}

public class Thirteen {
    public static void main(String[] args) {

        WaitandNotify wan = new WaitandNotify();
        Thread T1=new Thread(new Runnable() {
            @Override
            public void run() {
                wan.process1();
            }
        });

        Thread T2=new Thread(new Runnable() {
            @Override
            public void run() {
                wan.process2();
            }
        });

        T1.start();
        T2.start();

    }
}

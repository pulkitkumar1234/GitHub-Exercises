class SyncMethods {

    int count;

    public void Counter() {
        synchronized (this) {
            count++;
        }
        System.out.println("Counter Value: "+count);
    }

    public void process1() {
        for (int i = 1; i <= 10; i++) {
            Counter();
        }
    }

    public void Process2() {
        for (int i = 1; i <= 10; i++) {
            Counter();
        }
    }
}

public class Eleventh {

    public static void main(String[] args) throws InterruptedException {

        SyncMethods syncM = new SyncMethods();
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncM.process1();
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncM.Process2();
            }
        });

        T1.start();
        T2.start();
        T1.join();
        T2.join();

        System.out.println("Result of Counter: "+syncM.count);

    }
}

import java.util.concurrent.atomic.AtomicInteger;

class AutomicInteger {

    AtomicInteger count= new AtomicInteger();

    public void Counter() {
        count.incrementAndGet();
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

public class Twelveth {

    public static void main(String[] args) throws InterruptedException {

        AutomicInteger automicInteger = new AutomicInteger();
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                automicInteger.process1();
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                automicInteger.Process2();
            }
        });

        T1.start();
        T2.start();
        T1.join();
        T2.join();

        System.out.println("Result of Counter: "+automicInteger.count);

    }
}

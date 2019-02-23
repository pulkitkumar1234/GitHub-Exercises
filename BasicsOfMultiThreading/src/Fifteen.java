import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class reenLock {

    Lock l = new ReentrantLock(true);
    Condition condition = l.newCondition();

    public void process1() {
        try {
            l.lock();
            System.out.println("Started Process 1");
            condition.await();
            System.out.println("End Process 1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            l.unlock();
        }

    }

    public void process2() {
        try{
            l.lock();
            System.out.println("Started Process 1");
            System.out.println("End Process 1");
            condition.signal();
        }finally {
            l.unlock();
        }
    }

}

public class Fifteen {

    public static void main(String[] args) throws InterruptedException {

        reenLock rl = new reenLock();
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rl.process1();
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                rl.process2();
            }
        });

        T1.start();
        T2.start();
        T1.join();
        T2.join();


    }
}

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class reenLockDeadLock {

    Lock l1 = new ReentrantLock(true);
    Lock l2 = new ReentrantLock(true);

    public void process1(){
        l1.lock();
        System.out.println("Locked 1, Process Method 1 Thread: "+Thread.currentThread().getName());
        l2.lock();
        System.out.println("Locked 2, Process Method 1 Thread: "+Thread.currentThread().getName());
        //l2.unlock();
        //l1.unlock();
    }

    public void process2(){
        l1.lock();
        System.out.println("Locked 2, Process Method 2 Thread: "+Thread.currentThread().getName());
        l2.lock();
        System.out.println("Locked 1, Process Method 2 Thread: "+Thread.currentThread().getName());
        l2.unlock();
        l1.unlock();
    }


}

class reenLockNoDeadLock {

    Lock l1 = new ReentrantLock(true);
    Lock l2 = new ReentrantLock(true);

    public void acquireLock(Lock l1, Lock l2){

        boolean alock1= l1.tryLock();
        boolean alock2= l2.tryLock();

        if(alock1 && alock2){
            return;
        }

        if(alock1){
            l1.unlock();
        }

        if(alock2){
            l2.unlock();
        }

    }

    public void process1(){
        acquireLock(l1,l2);
        System.out.println("Locked 1, Process Method 1 Thread: "+Thread.currentThread().getName());
        System.out.println("Locked 2, Process Method 1 Thread: "+Thread.currentThread().getName());
        l2.unlock();
        l1.unlock();
    }

    public void process2(){
        acquireLock(l2,l1);
        System.out.println("Locked 1, Process Method 2 Thread: "+Thread.currentThread().getName());
        System.out.println("Locked 2, Process Method 2 Thread: "+Thread.currentThread().getName());
        l1.unlock();
        l2.unlock();
    }

}

public class Sixteen {

    public static void main(String[] args) throws InterruptedException {

        //reenLockDeadLock rld = new reenLockDeadLock();
        reenLockNoDeadLock rld=new reenLockNoDeadLock();
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rld.process1();
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                rld.process2();
            }
        });

        T1.start();
        T2.start();

    }
}

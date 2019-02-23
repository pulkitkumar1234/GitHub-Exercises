import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Third {
    public static void main(String[] args) {
        ExecutorService es= Executors.newSingleThreadExecutor();
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread::"+Thread.currentThread().getName()+" Executing Task 1");
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread::"+Thread.currentThread().getName()+"::Executing Task 2");
            }
        });

        System.out.println("Main Thread::"+Thread.currentThread().getName()+"::Executed");
    }
}

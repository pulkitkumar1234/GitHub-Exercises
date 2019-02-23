import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fourth2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        try{
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread::"+Thread.currentThread().getName()+"::Executing Task 1");
                }
            });

            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread::"+Thread.currentThread().getName()+":: Executing Task 2");
                }
            });
        }finally {
            es.shutdownNow();
        }

        System.out.println("Thread Termination Status::"+es.isTerminated());
        System.out.println("Thread ShutDown Shataus::"+es.isShutdown());
    }
}

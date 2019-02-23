import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fourth {
    public static void main(String[] args) {
        ExecutorService es= Executors.newSingleThreadExecutor();

        try{
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread::"+Thread.currentThread().getName()+"::Executing Task 1");
                }
            });

            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread::"+Thread.currentThread().getName()+"::Executing Task 2");
                }
            });
        }finally {
            es.shutdown();
        }

        System.out.println("Termination Status::"+es.isTerminated());
        System.out.println("Shutdown Status::"+es.isShutdown());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Termination Status::"+es.isTerminated());
    }
}

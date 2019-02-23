import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecuteThread implements Runnable{

    private int val;

    public ExecuteThread(int tval) {
        val = tval;
    }

    @Override
    public void run() {
        System.out.println("Thread "+Thread.currentThread().getName()+" First Values "+val);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread "+Thread.currentThread().getName()+" Last End :"+val);
    }
}

public class Ninth {

    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(3);
        //ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            executorService.submit(new ExecuteThread(i));
        }
        executorService.shutdown();
    }

}

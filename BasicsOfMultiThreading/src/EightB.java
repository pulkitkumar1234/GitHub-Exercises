import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class EightB {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                    System.out.println("Thread "+Thread.currentThread().getName()+" Task 1 [Executed After Fixed Interval]");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },0,1,TimeUnit.SECONDS);

    }

}

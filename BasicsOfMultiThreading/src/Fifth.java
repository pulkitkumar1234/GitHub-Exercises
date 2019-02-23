import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Fifth {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread "+Thread.currentThread().getName()+" Executing Task 1");
                }
            });


        }finally {
            executorService.shutdown();
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Executor Service Instance Termination Status :: "+executorService.isTerminated());
        System.out.println("Executor Service Instance Shutdown Status :: "+executorService.isShutdown());

    }

}

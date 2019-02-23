import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Seventh {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> runnList = new ArrayList<>();

        runnList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Thread "+Thread.currentThread().getName()+" Task 1");
                return 1;
            }
        });

        runnList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Thread "+Thread.currentThread().getName()+" Task 2");
                return 2;
            }
        });

        runnList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception { ;
                System.out.println("Thread "+Thread.currentThread().getName()+" Task 3");
                return 3;
            }
        });

        try {

            List<Future<Integer>> intFuture = executorService.invokeAll(runnList);

        }finally {
            executorService.shutdown();
        }

        executorService.awaitTermination(2000L,TimeUnit.MILLISECONDS);

        System.out.println("Main Thread Finished.");

    }
}

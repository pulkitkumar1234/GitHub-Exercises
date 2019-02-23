import java.util.concurrent.*;

class Sixth {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> intFuture;
        try {

            intFuture=executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //Thread.sleep(4000L);
                    System.out.println("Thread "+Thread.currentThread().getName()+" Executing Task 1");
                    return 100;
                }
            });



        }finally {
            executorService.shutdownNow();

        }

       Thread.sleep(1000L);

        if(intFuture.isDone()) {
            System.out.println(intFuture.get());
        }

        if(intFuture.isCancelled()) {
            System.out.println("Task was cancelled or not completed.");
        }

    }

}

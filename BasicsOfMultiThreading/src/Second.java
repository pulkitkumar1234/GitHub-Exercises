public class Second {

    public static void main(String[] args) throws InterruptedException {
     Thread t1=  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 Started.");
                try {
                    Thread.sleep(5000L);
                    System.out.println("Thread 1 Finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("Thread 2 Started.");
            }
        });

     Thread t2=new Thread(new Runnable() {
         @Override
         public void run() {
             System.out.println("Thread 2 Started.");
             try {
                 Thread.sleep(4000L);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("Thread 2 Finished");
         }
     });

     t1.start();
     t2.start();
     t1.join();
     t2.join();
    }

}


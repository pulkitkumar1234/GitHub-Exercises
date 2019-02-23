class WaitandNotifyAll {

    public void process1() {
        synchronized (this) {
            System.out.println("Thread "+Thread.currentThread().getName()+" Start");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+Thread.currentThread().getName()+" End");
        }
    }

    public void process2() {
        synchronized (this) {
            System.out.println("Thread "+Thread.currentThread().getName()+" Start");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+Thread.currentThread().getName()+" End");
        }
    }

    public void process3() {
        synchronized (this) {
            System.out.println("Thread "+Thread.currentThread().getName()+" Start");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+Thread.currentThread().getName()+" End");
        }
    }

    public void process4() {
        synchronized (this) {
            System.out.println("Thread "+Thread.currentThread().getName()+" Start");
            System.out.println("Thread "+Thread.currentThread().getName()+" End");
            notifyAll();
        }
    }
}

class FourTeen {

    public static void main(String[] args) {

        WaitandNotifyAll wana = new WaitandNotifyAll();
        Thread T1=new Thread(new Runnable() {
            @Override
            public void run() {
                wana.process1();
            }
        });

        Thread T2=new Thread(new Runnable() {
            @Override
            public void run() {
                wana.process2();
            }
        });

        Thread T3=new Thread(new Runnable() {
            @Override
            public void run() {
                wana.process3();
            }
        });

        Thread T4=new Thread(new Runnable() {
            @Override
            public void run() {
                wana.process4();
            }
        });

        T1.start();
        T2.start();
        T3.start();
        T4.start();

    }

}


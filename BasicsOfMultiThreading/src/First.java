class First extends Thread {
    public void run(){
        System.out.println("THREAD CLASS EXTENDED::"+Thread.currentThread().getName());
    }

}

class second2 implements Runnable{
    public void run(){
        System.out.println("RUNNABLE CLASS IMPLEMENTED::"+Thread.currentThread().getName());
    }
}

class ThreadClass{
    public static void main(String[] args) {
        First ft=new First();
        ft.start();

        second2 sc=new second2();
        Thread th=new Thread(sc);
        th.start();

        System.out.println("IN MAIN::"+Thread.currentThread().getName());
    }

}

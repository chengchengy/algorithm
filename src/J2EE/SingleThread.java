package J2EE;

public class SingleThread extends Thread {

    public static void main(String[] args) {
        Runnable r1 = new SingleThread("1");
        Thread t1 = new Thread(r1);
        t1.start();

        //share the name 2, use runnable
        SingleThread s1 = new SingleThread("2");
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s1);
        Thread t4 = new Thread(s1);

    }


    private String name;
    public SingleThread (String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Single: " + i);
        }
    }
}

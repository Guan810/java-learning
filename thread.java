import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.CountDownLatch;

public class thread extends Thread {
    final CountDownLatch c1 = new CountDownLatch(3);

    thread(ThreadGroup a, String name) {
        super(a, name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            compute();
        }
    }

    public static void main(String[] args) {
        ThreadGroup top = Thread.currentThread().getThreadGroup();
        new Thread(top, new thread2()).start();
        thread t1 = new thread(top, "t1");
        thread t2 = new thread(top, "t2");
        // thread t3 =new thread(top,"t3");
        t1.start();
        t2.start();
        // t3.start();
        // try {
        // Thread.sleep(1);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        for (int i = 0; i < 5; i++) {
            compute();
        }
    }

    static ThreadLocal<Integer> callOfNumber = new ThreadLocal<>();

    static synchronized void compute() {
        System.out.printf("At "+System.nanoTime());
        Integer n = (Integer) callOfNumber.get();
        if (n == null)
            n = new Integer(1);
        else
            n = new Integer(n.intValue() + 1);
        callOfNumber.set(n);
        System.out.println("    Current Thread is " + Thread.currentThread().getName() + " :" + n);
        long j = 0;
        for (long i = 0; i < 1000; i++) {
            j += i;
        }
        try {
            // System.out.println("==========================");
            // AllThread();
            Thread.sleep(100);
            // AllThread();
            // System.out.println("==========================");
        } catch (Exception e) {
            // // TODO: handle exception
            e.printStackTrace();
        }
        Thread.yield();

    }

    public synchronized static void AllThread() {
        ThreadGroup currG = Thread.currentThread().getThreadGroup();
        Thread[] ts = new Thread[currG.activeCount()];
        currG.enumerate(ts);
        for (Thread thread : ts) {
            System.out.println(thread.getName() + " --States----> " + thread.getState());
        }
        System.out.println();
    }

}

class thread2 implements Runnable {

    @Override
    public void run() {
        try {
            FileWriter fw = new FileWriter(new File("log.txt"));
            Thread[] ts=new Thread[3];
            int i=0;
            while (ts.length==2) {
                ThreadGroup currG = Thread.currentThread().getThreadGroup();
                ts = new Thread[currG.activeCount()];
                currG.enumerate(ts);
                for (Thread thread : ts) {
                    fw.append("[ "+i+" ] "+thread.getName() + " --States----> " + thread.getState());
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
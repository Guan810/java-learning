import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

/**
 * Runable
 */
public class Runable {

    private long basic;
    private LinkedList<ts> a;
    private String lock;
    final CountDownLatch c = new CountDownLatch(3);

    Runable() {
        basic = System.nanoTime();
        a = new LinkedList<>();
        lock = " ";
    }

    public synchronized void update() {

    }

    class runabl implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (lock) {
                    a.add(new ts(Thread.currentThread().getName(),System.nanoTime()-basic));
                    System.out.println(Thread.currentThread().getName() + " shifting costs " + a.getLast().time);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    basic = System.nanoTime();
                }
                Thread.yield();
            }
            c.countDown();
        }

    }

    public static void main(String[] args) {
        Runable ll = new Runable();
        new Thread(ll.new runabl()).start();
        new Thread(ll.new runabl()).start();
        new Thread(ll.new runabl()).start();
        try {
            ll.c.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LinkedList<Long> diff=new LinkedList<>();
        LinkedList<Long> same=new LinkedList<>();
        LinkedList<Long> whole=new LinkedList<>();
        LinkedList<ts> res=ll.a;
        for(int i=1;i<res.size();i++){
            ts tts=res.get(i);
            if(tts.time<100000){
                if(tts.name==res.get(i-1).name){
                    same.add(tts.time);
                }else{
                    diff.add(tts.time);
                }
                whole.add(tts.time);
            }
        }
        System.out.println("diff ave = "+ave(diff));
        System.out.println("same ave = "+ave(same));
        System.out.println("whole ave = "+ave(whole));
    }

    public static long ave(LinkedList<Long> a) {
        long sum=0;
        for (Long long1 : a) {
            sum+=long1;
        }
        return sum/a.size();
    }

}
class ts{
    String name;
    long time;
    ts(String s,long l){
        this.name=s;
        this.time=l;
    }
}
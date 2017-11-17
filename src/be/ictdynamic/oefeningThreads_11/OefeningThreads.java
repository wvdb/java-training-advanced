package be.ictdynamic.oefeningThreads_11;

/**
 * Created by admin on 20/09/2017.
 */
public class OefeningThreads extends Thread {
    private char c;
    private int count;

    public OefeningThreads(char c, int count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.print("\nthreadName " + threadName + ":");

        //        try {
//            Thread.sleep(20_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (int i=0; i<count; i++) {
            System.out.print(c);
        }
    }
}

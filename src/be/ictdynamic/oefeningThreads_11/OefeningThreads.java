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
        for (int i=0; i<count; i++) {
            System.out.print(c);
        }

        String threadName = Thread.currentThread().getName();
        System.err.println("\nthreadName " + threadName);

    }
}

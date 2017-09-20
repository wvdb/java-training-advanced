package be.ictdynamic.oefeningThreads_11;

/**
 * Created by admin on 20/09/2017.
 */
// ready to extend from another class
public class MyRunnable implements Runnable {
    private char c;
    private int count;

    public MyRunnable(char c, int count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i=0; i<count; i++) {
            System.out.print(c);
        }
    }
}

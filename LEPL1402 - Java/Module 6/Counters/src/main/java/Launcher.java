import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Launcher {

    /*
     * Instantiate and start each thread from "t" with its OWN Counter object,
     * then wait for all threads to finish and return the set of Counter objects
     * the threads ran on. Each thread must be named according to its index in the
     * "t" array.
     */
    public static Counter[] init(Thread[] t){
        Counter[] answer = new Counter[t.length];
        for (int i = 0; i < t.length; i++) {
            answer[i] = new Counter();
            t[i] = new Thread(answer[i], String.valueOf(i));
            t[i].start();
        }
        for (Thread thread: t){
            try {
                thread.join();
            } catch (InterruptedException e) {}
            }

        return answer;
    }
}

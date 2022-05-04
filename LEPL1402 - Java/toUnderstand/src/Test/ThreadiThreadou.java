package Test;

public class ThreadiThreadou implements Runnable {
    String text;

    public ThreadiThreadou(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        System.out.println(text);
    }


    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {

                System.out.println("François");
                Thread.sleep(1500);
                System.out.println("J'ai très envie");
                Thread.sleep(1000);
                System.out.println("de jouer à Fortnite...");

            } catch (InterruptedException e) {
                throw new RuntimeException("Unexpectded errupt",e);
            }
        });
        t.start();

        try {

            t.join();

        } catch (InterruptedException e) {

            throw new RuntimeException("An error appeared", e);

        }
    }

}

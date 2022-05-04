package Test;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                System.out.println(i);
            }
        }, "My new Thread");
        t.start();
        System.out.println("caca");
        String name = "This is " + t.getName();
        System.out.println(name);
    }
}

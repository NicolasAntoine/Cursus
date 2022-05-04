package Test;

class Sum implements Runnable {
    final int a,b;
    int sum;

    public Sum(int a, int b){
        this.a =a;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = a; i < b; i++) {
            sum+=i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Sum s1 = new Sum(0,5000);
        Sum s2 = new Sum(5001, 1000);
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);

        t1.start();t2.start();t1.join();t2.join();
        int sum = s1.sum+ s2.sum;
        System.out.println(sum);

    }
}
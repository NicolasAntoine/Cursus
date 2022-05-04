public class Fibonacci {

    //f(n) = f(n-1) + f(n-2)
    //f(0) = 0
    //f(1) = 1
    //f(2) = 1
    //f(3) = 2
    //f(4) = 3
    //f(5) = 5
    //f(6) = 8
    //f(7) = 13
    //f(8) = 21
    //etc

    public static int fiboRecursive(int index){
        if (index <=1){
            return index;
        }
        else {
            return fiboRecursive(index-1) + fiboRecursive(index-2);
        }
    }
    public static int fiboIterative(int index){
        if (index <= 1){
            return index;
        }
        int fn_1 = 1;
        int fn_2 = 1;
        int tmp = 0;
        for (int i = 2; i < index; i++) {
            tmp = fn_1;
            fn_1 = fn_1 + fn_2;
            fn_2 = tmp;
        }
        return fn_1;
    }

    public static void main(String[] args) {
        System.out.println(fiboRecursive(7));
        System.out.println(fiboIterative(4));
    }
}

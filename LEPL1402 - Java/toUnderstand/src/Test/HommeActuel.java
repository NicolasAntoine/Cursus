package Test;

public class HommeActuel implements HomosSapiens{
    @Override
    public void walk() {
        System.out.println("Je marche.");
    }

    @Override
    public void talk() {
        System.out.println("Je parle.");
    }

    @Override
    public void sleep() {
        System.out.println("Je dors.");
    }

    public static void math(){
        System.out.println("Je sais faire des maths.");
    }
}

class Launch{
    public static void main(String[] args) {
        HommeActuel hommeActuel = new HommeActuel();
        hommeActuel.sleep();
        hommeActuel.walk();
        hommeActuel.talk();
        hommeActuel.math();
    }
}
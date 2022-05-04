package Test;

public class mains {
    public static void main(String[] args) {
        Cat cat = new Cat(/* ... */);
        Dog dog = new Dog(/* ... */);
        FrenchBouledogue fb = new FrenchBouledogue(/* ... */);
        Dog dog2 = (Dog) fb;

        System.out.println(cat.shout());
        System.out.println(dog.shout());
        System.out.println(fb.shout());
        System.out.println(dog2.shout());
    }
}

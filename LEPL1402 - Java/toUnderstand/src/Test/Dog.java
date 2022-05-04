package Test;

class Dog extends Mammal{
    int height = 80;
    int jumpHeight = 100;

    @Override
    String shout() {
        return "Wouf";
    }
}
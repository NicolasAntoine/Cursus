package Test;

abstract class Mammal extends Animal{
    int jumpHeight = -1;
    boolean canJump(){
        return jumpHeight > 0;
    }
}

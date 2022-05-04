package Playlist_5a.AnonymousInnerClass;

public class AnonymousInnerClass {

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Cat myBigCat = new Cat() {
            @Override
            public void makeNoiseWhenGetHurt() {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAARGH");
            }
            public void walk() {
                System.out.println("poum poum poum");
            }
        };

        myBigCat.makeNoiseWhenGetHurt();
        myBigCat.walk();
        myCat.makeNoiseWhenGetHurt();
        myCat.walk();
    }

}

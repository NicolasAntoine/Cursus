package Playlist_5a.LambdaExpression;

public class LambdaExpress {

    public static void formatted(String str, myString s){
        String answer = s.run(str);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        myString exclaim = (s -> s + "!");
        myString neutral = (s -> s + ".");
        myString interrogative = (s -> s + "?");
        formatted("You're bad at FIFA", exclaim);
        formatted("You're bad at FIFA", neutral);
        formatted("You're bad at FIFA", interrogative);
    }
}

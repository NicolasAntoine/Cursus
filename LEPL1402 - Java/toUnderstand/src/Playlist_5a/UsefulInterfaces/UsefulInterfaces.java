package Playlist_5a.UsefulInterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class UsefulInterfaces {
    Function<Double,Double> f = (d -> Math.sqrt(d)); //prend un double et retourne un double
    BiFunction<Integer, Double, String> f1 = (p1,p2) -> {
        if (p1 < p2 ) {
            return "p1 est plus petit";
        } else {
            return "p1 est plus grand ou égal à 2";
        }
    };

}

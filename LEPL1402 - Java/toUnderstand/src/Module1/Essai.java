package Module1;

import java.util.stream.Stream;

public class Essai {
    public static void main(String[] args) {;
        streamPrinted(streamIncrement(Stream.of(1,2,3,4)));
        streamPrinted(Stream.of(1,2,3,4,5));
        Stream<Integer> a = Stream.of(1,2,3,4,5);
        int e = a.reduce(5 , Integer::sum);
        System.out.println(e);
    }

    public static Stream<Integer> streamIncrement(Stream<Integer> stream){
        return stream.map((integer -> integer++));
    }

    public static void streamPrinted(Stream<Integer> stream){
        stream.forEach((integer -> System.out.println(integer)));
    }
}

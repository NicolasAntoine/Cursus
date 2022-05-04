package Playlist_5a.LambdaExpression;

import Playlist_5a.LambdaExpression.Duck;

import java.util.Comparator;

public class DuckComparator implements Comparator<Duck> {
    @Override
    public int compare(Duck o1, Duck o2) {
        if (o1.weight == o2.weight){
            return o1.height - o2.height;
        }
        return o1.weight - o2.weight;
    }
}

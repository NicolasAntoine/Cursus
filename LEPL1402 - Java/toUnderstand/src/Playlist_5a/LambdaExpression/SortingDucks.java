package Playlist_5a.LambdaExpression;

import Playlist_5a.LambdaExpression.Duck;

import java.util.Arrays;

public class SortingDucks {
    public static String[] getPrinted(Duck[] tab){
        String[] answer = new String[tab.length];
        int a = 0;
        for (Duck i : tab){
            answer[a] = i.name;
            a++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Duck Harold = new Duck(5, 50, "Harold");
        Duck Gerard = new Duck(6, 45, "Gerard");
        Duck Christophe = new Duck(8, 35, "Christophe");

        Duck[] tab = new Duck[]{Harold, Gerard, Christophe};
        Arrays.sort(tab, ((o1, o2) -> o2.weight - o1.weight));
        String[] a = getPrinted(tab);
        System.out.println(Arrays.toString(a));
    }
}


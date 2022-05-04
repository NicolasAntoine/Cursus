package Test;

import java.util.ArrayList;
import java.util.List;

public class testWhile {

    public static int binarySearch(List<Integer> list, int valueToFind) {
        int minIdx = 0;
        int maxIdx = list.size();
        while (minIdx != maxIdx - 1) {
            int mid = (maxIdx + minIdx)/2;
            int val = list.get(mid);

            if(val == valueToFind)
                return mid;
            if(val < valueToFind)
                minIdx = mid;
            else
                maxIdx = mid;
        }
        return list.get(minIdx) == valueToFind ? minIdx : -minIdx-1;
    }

    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(10);

        System.out.println(binarySearch(liste, 10));
    }

}

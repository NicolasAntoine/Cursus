
import java.util.ArrayList;
import java.util.List;

public class Except{
    
    
    public static void outof(){
        int[] array = new int[]{1,2,3,4,5};
        for (int i = 0; i < array.length+1; i++) {
            array[i]++;
        }
    }
    
    public static void concurr(){
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        for(int i: array){
            if (i == 1) {
                array.add(4);
            }
        }
    }
    
    public static void nullpointer(){
        int[] array = null;
        System.out.println(array[0]);
    }

    public static void main(String[] args) {
        concurr();
    }
    
    
}
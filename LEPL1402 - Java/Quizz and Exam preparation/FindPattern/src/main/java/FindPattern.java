import java.util.ArrayList;
import java.util.List;

public class FindPattern {

    /**
     * In this task you must find the first occurrence of a pattern in a
     * sequence.
     * This occurrence might also be **in a different order** than in 
     * the pattern.
     * 
     * For example, let:
     *      pattern = [1, 1, 3, 5]
     *      sequence = [3, 1, 2, 5, 1, 3, 1, 5, 1]
     *
     * Starting at index 3, we have the sub-sequence [5, 1, 3, 1] which
     * is the pattern reordered. Thus your method must return 3.
     * Note that the pattern also appears at index 4, but you must
     * return the first occurrence.
     * If the pattern is not in the sequence, you must return -1.
     *
     * @param pattern The pattern to look for
     * @param sequence The sequence to look in. Each element of the sequence is
     *        in the interval [0, 15]
     * @return The index of the first occurrence of the pattern in the
     *         sequence or -1 if the pattern is not in the sequence
     */
    public static int find(int [] pattern, int [] sequence) {
        int depart = 0;
        int fin = pattern.length-1;
        while (fin < sequence.length){
            List<Integer> liste = new ArrayList<>();
            for (int i = 0; i < pattern.length; i++) {
                liste.add(pattern[i]);
            }
            List<Integer> compared = new ArrayList<>();
            for (int i = depart; i < fin+1 ; i++) {
                compared.add(sequence[i]);
            }
            int test= verif(liste, compared);
            if (test == pattern.length){
                return depart;
            }
            depart++;
            fin++;
        }
        return -1;
    }
    public static int verif(List<Integer> liste, List<Integer> compared){
        int counter = 0;
        for (Integer i : compared){
            if (liste.contains(i)){
                counter++;
                liste.remove(i);
            }
        }
        return counter;
    }

}

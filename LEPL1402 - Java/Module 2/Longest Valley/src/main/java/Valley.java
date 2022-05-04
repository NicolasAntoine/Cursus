import java.util.Arrays;

public class Valley{

    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slopes A non-empty array of slope
     * @return An array of two element. The first is the
     *         depth of the deepest valley and the second
     *         the height of the highest mountain
     */
    public static int[] valley (int[] slopes) {
        int pos = 0, neg = 0, mountain = 0, descent = 0, greatestMountain = 0, greatestValley = 0;
        for (int i = 0; i < slopes.length; i++) {
            if (slopes[i] < 0){
                neg++;
            }
            if (slopes[i] > 0){
                pos++;
            }
            if (pos-neg == 0){
                if (greatestMountain < pos){
                    greatestMountain = pos;
                }

            }
        }
    }
    public static void main(String[] args) {
        //int [] tab = new int[]{1,1,1,-1,-1,-1,-1,-1,1,1,1,1,1,1,-1,-1};
        int[] tab = new int[]{1,1,1,-1,-1,1,1,-1,-1};
        System.out.println(Arrays.toString(valley(tab)));

    }
}

import java.util.Arrays;
import java.util.function.Predicate;


/**
 * Question:
 *
 * You are asked to complete the two TODO belows:
 *
 * - the add method appending an element at the end of the linked-list
 * - the filter method that returns a new LinkedListWithFilter containing
 *   the same elements in the same order but only the ones satisfying the predicate (condition)
 *   are kept.
 *
 *   Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 */
public class CovidStatistics {


    /**
     * It must be computed in Theta(n) where n is the length of data
     * Each entry is the average computed on the window days before
     * @param data the input array
     * @param window the number of days to compute the average > 1
     * @return an array res that contains the rolling average
     *         on the window days before computed on data
     *         More formally, res has the same length as data
     *         res[i] = average(data[0:i]) for i < window
     *         res[i] = average(data[i-window+1:i]) for i >= window
     *
     */
    public static double[] rollingAverage(int [] data, int window) {
        double[] average = new double[data.length];
        int sum = 0;
        for (int i = 0; i<data.length; i++){
            if (i<window){
                sum += data[i];
                average[i] = (double) sum/(i+1);
            }else{
                sum = sum + data[i] - data[i-window];
                average[i] = (double) sum/window;
            }
        }
        return average;
    }

    /**
     * It must be computed in Theta(n) where n is the length of data
     * Each entry is the the sum of the prefix of values
     * up and including this entry
     * @param data the input array
     * @return an array res that contains the prefix sum
     *         More formally, res has the same length as data and contains
     *         sum[i] = sum(data[0:i])
     *
     */
    public static int[] cumulativeSum(int [] data) {
        int sum =0;
        int[] res = new int[data.length];
        for(int i =0; i< data.length; i++){
            sum+=data[i];
            res[i] = sum;
        }
        return res;
    }

    /**
     * It must be computed in O(n) where n is the length of data
     * Return the index of the first entry satisfying the predicate test
     * @param data
     * @param p the predicate test
     * @return the index of the first entry satisfying the predicate p,
     *         -1 if no such index
     */
    public static int index(int [] data, Predicate<Integer> p) {
        for (int i =0; i<data.length; i++){
            if (p.test(data[i])){
                return i;
            }
        }
        return -1;
    }
}


public class MaximumSubArray {


    /**
     * Find the contiguous subarray with the maximal sum
     *
     * @param a a non-empty array
     * @return A triplet (sum, start, end) with sum the sum of the subarray and `start` and `end` the
     *         start and end of the subarray
     *
     * For example for the array [-2,1,-3,4,-1,2,1,-5,4] your method should return [6, 3, 6]
     */
    public static int[] maxSubArray(int[] a) {
        int sum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int secondSum = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            secondSum += a[i];
            if (secondSum >  sum){
                sum = secondSum;
                start = index;
                end = i;
            }
            if (secondSum < 0){
                secondSum = 0;
                index = i+1;}

        }
        int [] x = new int[]{sum,start,end};
        return x;
    }
        public static void main(String[] args) {
            int[] rep = maxSubArray(new int[]{-1,-2,-5});
            //should return [6,3,6]
            for (int i = 0; i < rep.length; i++) {
                System.out.println(rep[i]);
            }
        }
}

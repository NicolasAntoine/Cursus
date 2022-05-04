// You are allowed to add imports here

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindMaxInMatrix {
    // You are allowed to add methods or class members here


    public static class Result {
        public int row, column;

        public Result(int row, int column) {
            this.row=row;
            this.column=column;
        }
    }

    public static Result maxRow(int[]row, int n){
        Result res = new Result(n,0);
        int max = row[0];
        for(int i = 0; i<row.length; i++){
            if (row[i]> max){
                max = row[i];
                res = new Result(n, i);
            }
        }
        return res;
    }

    public static Result findMax(int[][] matrix, int nThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        List<Future<Result>> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            final int a = i;
            res.add(executor.submit(() -> maxRow(matrix[a], a)));
        try {
            Result max = res.get(0).get();
            for (int j = 0; j < res.size(); j++) {
                Result item = (Result) res.get(j).get();
                if (matrix[max.row][max.column] < matrix[item.row][item.column]) {
                    max = item;
                }
            }
            executor.shutdown();
            return max;
        } catch (ExecutionException| InterruptedException e) {return new Result(0,0);}
    }

    /**
     * This method finds the position of greatest element in a square matrix.
     * The matrix has only ONE greatest element.
     * Your solution MUST use threads to accelerate the search for the
     * greatest element.
     * The matrix is represented by a two-dimensional array.
     *
     * For example, if the method is called with the following matrix
     *     (1  2  3)
     *     (3  4  5)
     *     (3  0  3)
     * then the result is row=1, column=2 because 5 is the greatest element.
     *
     *
     * @param matrix a rectangular matrix
     * @param nThreads the number of threads to use
     * @return the row and column of the greatest element
     *
     * You can assume in your solution that:
     *    -  nThreads>0
     *    -  nThreads<=the number of rows and the number of columns of the matrix
     *    -  matrix is a square matrix and has at least one element
     *    -  all elements in the matrix are >=0
     *    - You can ignore (i.e. catch) exceptions
     */
}

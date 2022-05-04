// You are allowed to add imports here

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IncrementMatrix {
    // You are allowed to add methods or class members here


    public static int[] rowIncrement(int[]row){
        int []newRow = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            newRow[i] = row[i] + 1;
        }
        return newRow;
    }

    /**
     * This methods returns a new matrix that is identical
     * to the input matrix, but every element is incremented by one.
     * The matrix is represented by a two-dimensional array.
     * Example:
     *    Input:
     *        (0 1 2)
     *        (3 4 5)
     *        (6 7 8)
     *    Output:
     *        (1 2 3)
     *        (4 5 6)
     *        (7 8 9)
     * Your solution MUST use threads to accelerate the operation.
     * The method MUST NOT modify the input matrix!
     *
     * @param matrix the input matrix
     * @param nThreads the number of threads to use
     * @return a matrix where every element of the input matrix is incremented by one
     *
     * You can assume in your solution that:
     *    -  nThreads>0
     *    -  nThreads<=the number of rows and the number of columns of the matrix
     *    -  matrix is a square matrix and has at least one element
     *    -  You can ignore (i.e. catch) exceptions
     */


    public static int[][] increment(int[][] matrix, int nThreads) {
        // TODO
        // Hint: Each row of the matrix could be seen as a "job"
        // for a thread.
        // Hint: In the course and in the quiz, we have seen Futures
        // that have Integer values as result. What would be the result
        // of a Future here?

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        List<Future<int[]>> listFuture = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            listFuture.add(executor.submit(()-> rowIncrement(row)));
        }

        int[][] newMatrix = new int[matrix.length][];

        for (int i = 0; i < matrix.length ; i++) {

            try {
                newMatrix[i] = listFuture.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
            } finally {
                executor.shutdown();
            }
        }

         return newMatrix;
    }

}



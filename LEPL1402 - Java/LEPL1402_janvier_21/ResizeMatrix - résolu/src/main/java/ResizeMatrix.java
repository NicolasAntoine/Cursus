// No imports needed for this task

import java.util.Arrays;

public class ResizeMatrix {
    /*public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{3,4}};
        for (int [] line: matrix) {
            System.out.println(Arrays.toString(line));
        }
        int n = 2;
        int p = 1;
        int i = matrix.length;
        int j = matrix[0].length + n;
        int [][] rep = new int[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if(l<p) rep[k][l] = matrix[k][l];
                if(l>=p && l<p+n) rep[k][l] = 0;
                if(l>= p+n) rep[k][l] = matrix[k][l-n];

            }

        }
        for (int [] line: rep) {
            System.out.println(Arrays.toString(line));
        }
    }*/
    // No new methods or class members needed for this task

    /**
     * This method takes a rectangular matrix like
     *          (  1   2   3   4 )
     *          (  5   6   7   8 )
     *          (  9   10  11  12)
     *  and returns a new matrix with the same values as the original
     *  matrix but with one or more empty columns added:
     *          (  1   0   0   2   3   4 )
     *          (  5   0   0   6   7   8 )
     *          (  9   0   0   10  11  12)
     *
     * @param matrix a rectangular matrix represented by a two-dimensional array.
     * @param p the position where the new columns should be inserted.
     * @param n the number of empty columns to insert.
     * @return the new matrix with the inserted columns
     *
     * Matrices are represented as two-dimensional arrays. For, example
     * a matrix with 2 rows and 5 columns is an int[2][5] array.
     *
     * The method inserts "n" new columns before the column with index "p".
     * For example, if p=0 and n=2 that means that two new columns are inserted
     * before the first column. If p=1, it means that the new columns are
     * inserted before the second column, etc.
     * If "p" is greater or equal the number of columns in the matrix,
     * the new columns are added after the last column.
     *
     * You can assume in your solution that
     *     -  p>=0
     *     -  n>=1
     *     -  the matrix has at least 1 row and 1 column
     */
    public static int[][] insertEmptyColumns(int[][] matrix, int p, int n) {
        int i = matrix.length;
        int j = matrix[0].length + n;
        int [][] rep = new int[i][j];
        if(p>=i){
            for (int k = 0; k < i; k++) {
                for (int l = 0; l < j; l++) {
                    if(l<j-n) rep[k][l] = matrix[k][l];
                    else{
                        rep[k][l] = 0;
                    }
                }
            }return rep;
        }
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if(l<p) rep[k][l] = matrix[k][l];
                if(l>=p && l<p+n) rep[k][l] = 0;
                if(l>= p+n) rep[k][l] = matrix[k][l-n];
            }

        }
        return rep;
    }
}

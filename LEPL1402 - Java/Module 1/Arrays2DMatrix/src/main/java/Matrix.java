import java.util.ArrayList;
import java.util.List;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] array = s.split("\n"); //[["1","2","3"], ["10","11"]]
        String[] part1 = array[0].split(" "); //[["1"],["2"],["3"]]
        String[] part2 = array[1].split(" "); //[["10],["11"]]
        int[] ligne1 = new int[part1.length];
        int[] ligne2 = new int[part2.length];
        for (int i = 0; i < part1.length; i++) {
            ligne1[i] = Integer.parseInt(part1[i]);
        }
        for (int i = 0; i < part2.length; i++) {
            ligne2[i] = Integer.parseInt(part2[i]);
        }
        int[][] answer = new int[][]{ligne1, ligne2};
        return answer;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int somme = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                somme += matrix[i][j];
            }
        }
        return somme;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {               // [1,2,3]
        int[][] answer = new int[matrix[0].length][matrix.length];  // [10,11]
        for (int i = 0; i < matrix.length; i++) { //0->1
            for (int j = 0; j < matrix[0].length; j++) { //0->2
                answer[i][j] = matrix[j][i];
            }
        }
        return answer;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        buildFrom("1 2 3\n10 11");
    }
}

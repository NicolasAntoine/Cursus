/**
 * Question:
 * <p>
 * You are asked to implement the Matrix abstract data-type below
 * <p>
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 * <p>
 * <p>
 * Feel free to add inner-class, methods or fields in the class
 * but do not modify the signature of existing methods
 */
public interface Matrix {

    /**
     * Factory: Creates a n x m integer matrix of zeros
     *
     * @param n the number of row
     * @param m the number of columns
     */
    public static Matrix create(int n, int m) {
        return new Matrix() {

            public int nc = n;
            public int mc = m;
            public int[][] matrix = new int[nc][mc];

            @Override
            public void set(int r, int c, int v) {
                matrix[r][c] = v;
            }

            @Override
            public int get(int r, int c) {
                return matrix[r][c];
            }

            @Override
            public Matrix deleteRow(int r) {
                Matrix m = Matrix.create(nc - 1, mc);
                int k = 0;
                for (int i = 0; i < nc; i++) {
                    if (i != r){
                        for (int j = 0; j < mc; j++) {
                            m.set(k, j, matrix[i][j]);
                        }
                        k++;
                    }
                }
                //System.out.println(" ");
                return m;
            }

            @Override
            public Matrix deleteColumn(int c) {
                Matrix m = Matrix.create(nc, mc - 1);
                int k = 0;
                for (int i = 0; i < nc; i++) {
                    k = 0;
                    for (int j = 0; j < mc; j++) {
                        if (j != c){
                            m.set(i, k, matrix[i][j]);
                            k++;
                        }
                    }
                }
                return m;
            }
        };
    }

    /**
     * Set the value v at row r, column j
     *
     * @param r the row
     * @param c the column
     */
    void set(int r, int c, int v);


    /**
     * Get the value v at row r, column c
     *
     * @param r the row
     * @param c the column
     */
    public int get(int r, int c);

    /**
     * Return a new version of the matrix with the specified row deleted
     * The current matrix is unchanged
     *
     * @param r the row to delete
     */
    public Matrix deleteRow(int r);

    /**
     * Return a new version of the matrix with the specified column deleted
     * The current matrix is unchanged
     *
     * @param c the column to delete
     */
    public Matrix deleteColumn(int c);

}






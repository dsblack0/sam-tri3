public class Matrix {
    private final int[][] matrix;

    // store matrix
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // Hack: create toString method using nested for loops to format output of a matrix
    

    // declare and initialize a matrix for a keypad
    static int[][] keypad() {
        return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
    }

    // declare and initialize a random length arrays
    static int[][] numbers() {
        return new int[][]{ { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    public String toString() {
      StringBuilder matrixBuild = new StringBuilder("");
      for (int row=0; row < matrix.length; row++) {
        StringBuilder rowBuild = new StringBuilder("");
        for (int col=0; col < matrix[row].length; col++) {
          if (matrix[row][col] < 0) {
            rowBuild.append("  ");
          } else {
           rowBuild.append(Integer.toHexString(matrix[row][col]) + " "); 
          }
        }
        matrixBuild.append(rowBuild + "\n");
      }

     for (int row=matrix.length-1; row >=0 ; row--) {
        StringBuilder rowBuild = new StringBuilder("");
        for (int col=matrix[row].length-1; col >= 0; col--) {
          if (matrix[row][col] < 0) {
            rowBuild.append("  ");
          } else {
           rowBuild.append(Integer.toHexString(matrix[row][col]) + " "); 
          }
        }
        matrixBuild.append("\n" + rowBuild);
      }
      
      return matrixBuild.toString();
    }

    // tester method for matrix formatting
    public static void main(String[] args) {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);

        Matrix m1 = new Matrix(numbers());
        System.out.println("Numbers Systems:");
        System.out.println(m1);
    }

}
public class Lab1 {

  public static void main(String[] args) {
    final float[][] A = {
        {-10.7f, -8f, 999.9f},
        {0.531f, 21.2f, 0f},
        {-743.9f, 0.81f, 150.1f},
    };
    final float[][] B = {
        {0f, 0f, -999.9f},
        {-32.5f, 4.3f, 163.12f},
        {0.98f, -2.0f, 0f}
    };

    try {

      validateMatrices(A, B);

      float[][] C = xorMatrices(A, B);
      System.out.println("1. Matrix C:");
      printMatrix(C);

      float sum = calcColMaxElemsSum(C);
      System.out.println("2. Sum of maximum elements in each column: " + sum);

    } catch (IllegalArgumentException e) {
      System.err.println("Execution failed. " + e.getMessage());
      System.exit(1);
    }
  }

  public static float[][] xorMatrices(float[][] m1, float[][] m2) {
    int rows = m1.length;
    int cols = m1[0].length;

    float[][] resM = new float[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        float n1 = m1[i][j];
        float n2 = m2[i][j];

        int n1Bits = Float.floatToIntBits(n1);
        int n2Bits = Float.floatToIntBits(n2);
        int xorBits = n1Bits ^ n2Bits;

        float res = Float.intBitsToFloat(xorBits);

        if (Float.isNaN(res)) {
          throw new IllegalArgumentException(String.format(
              "Cannot properly perform XOR operation for %f and %f at position (%d, %d)",
              n1, n2, i, j));
        }

        resM[i][j] = res;
      }
    }

    return resM;
  }

  public static float calcColMaxElemsSum(float[][] matrix) {
    float sum = 0;

    for (int j = 0; j < matrix[0].length; j++) {
      float max = matrix[0][j];
      for (int i = 1; i < matrix.length; i++) {
        if (matrix[i][j] > max) {
          max = matrix[i][j];
        }
      }
      sum += max;
    }

    return sum;
  }

  public static void validateMatrices(float[][] m1, float[][] m2) {
    if (m1 == null || m2 == null) {
      throw new IllegalArgumentException("Matrices 1 and 2 must not be null.");
    }

    int m1Rows = m1.length;
    int m1Cols = m1[0].length;

    if (m1Cols == 0) {
      throw new IllegalArgumentException("Matrix 1 must have at least one column.");
    }

    if (m2.length != m1Rows) {
      throw new IllegalArgumentException(String.format(
          "Matrix 2 must have the same number of rows as matrix 1. Expected %d but found %d.",
          m1Rows, m2.length));
    }

    for (int i = 0; i < m1Rows; i++) {
      if (m1[i].length != m1Cols) {
        throw new IllegalArgumentException(String.format(
            "All rows in matrix 1 must have the same number of columns. Row %d has %d columns but expected %d.",
            i, m1[i].length, m1Cols));
      }

      if (m2[i].length != m1[i].length) {
        throw new IllegalArgumentException(String.format(
            "Matrices 1 and 2 must have the same dimensions. Mismatch at row %d: matrix 1 has %d columns, matrix 2 has %d columns.",
            i, m1[i].length, m2[i].length));
      }
    }
  }

  public static void printMatrix(float[][] m) {
    for (float[] row : m) {
      for (float elem : row) {
        System.out.printf("%45.3f\t", elem);
      }
      System.out.println();
    }
  }
}

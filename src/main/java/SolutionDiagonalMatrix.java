// Pablo Sosa (psosa_ar@yahoo.com)
// 30/04/18


import java.util.Arrays;

import static java.lang.Math.abs;

public class SolutionDiagonalMatrix {

  static class SquareMatrix {
    int[][] matrix;
    int dimension;

    public SquareMatrix(int[][] matrix) {
      validateSquare(matrix);
      validateConstraints(matrix);
      this.matrix = matrix;
      this.dimension = matrix.length;
    }

    private void validateConstraints(int[][] matrix) {
      int matrixDimension = matrix.length;
      for (int i = 0; i < matrixDimension; i++) {
        for (int j = 0; j < matrixDimension; j++) {
          if (matrix[i][j] > 100 || matrix[i][j] < -100) {
            throw new IllegalArgumentException("The value " + matrix[i][j] + " is outside the boundaries");
          }
        }
      }
    }

    private void validateSquare(int[][] matrix) {
      int rowLength = matrix.length;
      Arrays.stream(matrix).forEachOrdered(column -> {
        if (column.length != rowLength) {
          throw new IllegalArgumentException("The matrix is not square");
        }
      });

    }

    int[] diagonal() {
      int[] diagonal = new int[dimension];
      for (int i = 0; i < dimension; i++) {
        diagonal[i] = matrix[i][i];
      }
      return diagonal;
    }

    int[] antiDiagonal() {
      int[] diagonal = new int[dimension];
      for (int i = 0; i < dimension; i++) {
        diagonal[i] = matrix[i][dimension - i - 1];
      }
      return diagonal;
    }

    SquareMatrix transpose() {
      int[][] transposed = new int[dimension][dimension];
      for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++) {
          transposed[i][j] = matrix[j][i];
        }
      }

      return new SquareMatrix(transposed);
    }
  }

  /*
   * Complete the diagonalDifference function below.
   */
  static int diagonalDifference(int[][] a) {
    SquareMatrix squareMatrix = new SquareMatrix(a);
    int[] diagonal1 = squareMatrix.diagonal();
    int[] diagonal2 = squareMatrix.antiDiagonal();
    int sumDiagonal = Arrays.stream(diagonal1).sum();
    int sumAntiDiagonal = Arrays.stream(diagonal2).sum();
    return abs(sumDiagonal - sumAntiDiagonal);
  }

}

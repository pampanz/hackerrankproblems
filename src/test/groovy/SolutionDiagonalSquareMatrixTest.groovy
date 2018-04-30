import spock.lang.Specification
import spock.lang.Unroll

class SolutionDiagonalSquareMatrixTest extends Specification {

  void "Given a non square matrix then an exception is returned"() {
    given:
    int[][] matrix = [
        [11, 2],
        [4, 5, 6],
        [10, 8, -12]
    ]
    when:
    SolutionDiagonalMatrix.diagonalDifference(matrix)

    then:
    thrown(IllegalArgumentException)
  }

  @Unroll
  void "Given matrix #description then an exception is returned"() {
    when:
    SolutionDiagonalMatrix.diagonalDifference(matrix as int[][])

    then:
    thrown(IllegalArgumentException)

    where:

    matrix                                   | description
    [[11, 2, 101], [4, 5, 6], [10, 8, -12]]  | "Over upper bound"
    [[11, 2, 100], [4, 5, 6], [10, 8, -101]] | "Over lower bound"
  }

  void "Given the basic example on the page then the diagonal difference is properly calculated"() {
    given:
    int[][] matrix = [
        [11, 2, 4],
        [4, 5, 6],
        [10, 8, -12]
    ]
    when:
    int answer = SolutionDiagonalMatrix.diagonalDifference(matrix)

    then:
    answer == 15
  }
}

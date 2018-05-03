import spock.lang.Specification
import spock.lang.Unroll

class SolutionLeftRotationTest extends Specification {

  @Unroll
  void "Given invalid input #description then an exception #expected is thrown"() {
    when:
    SolutionLeftRotation.leftRotate(leftRotations, inputLength, inputArray as int[])
    then:
    thrown(expected)
    where:
    description                                   || expected                || inputLength                 || leftRotations || inputArray
    "with length too small"                        | IllegalArgumentException | 0                            | 1              | []
    "with length too large"                        | IllegalArgumentException | (Math.pow(10, 5) + 1) as int | 1              | []
    "with number of rotations above upper bound"   | IllegalArgumentException | 1                            | 2              | [1]
    "with number of rotations below lower bound"   | IllegalArgumentException | 1                            | 0              | [1]
    "with array value too small"                   | IllegalArgumentException | 1                            | 1              | [0]
    "with array value too large"                   | IllegalArgumentException | 1                            | 1              | [(Math.pow(10, 6) + 1) as int]
    "with length different to actual array length" | IllegalArgumentException | 2                            | 1              | [1]
    "with length different to actual array length" | IllegalArgumentException | (Math.pow(10, 5)) as int     | 1              | new int[(Math.pow(10, 5) + 1) as int]
  }

  @Unroll
  void "Given valid input #description then printed rotation is #expected"() {
    when:
    String answer = SolutionLeftRotation.leftRotate(leftRotations, inputLength, inputArray as int[])
    then:
    answer == expected
    where:
    description          || expected   || inputLength || leftRotations || inputArray
    "Rotate 1"            | "2 3 4 5 1" | 5            | 1              | [1, 2, 3, 4, 5] as int[]
    "Rotate 2"            | "3 4 5 1 2" | 5            | 2              | [1, 2, 3, 4, 5] as int[]
    "Rotate 3"            | "4 5 1 2 3" | 5            | 3              | [1, 2, 3, 4, 5] as int[]
    "Example of the page" | "5 1 2 3 4" | 5            | 4              | [1, 2, 3, 4, 5] as int[]
    "Rotate 5"            | "1 2 3 4 5" | 5            | 5              | [1, 2, 3, 4, 5] as int[]
  }
}

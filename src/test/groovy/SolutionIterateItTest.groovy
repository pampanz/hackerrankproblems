import spock.lang.Specification
import spock.lang.Unroll

class SolutionIterateItTest extends Specification {

  @Unroll
  void "When the #description then #exception is thrown"() {
    when:
    SolutionIterateIt.iterateIt(input as int[])
    then:
    thrown(exception)
    where:
    description                  | input                                           | exception
    "array is too small"         | []                                              | IllegalArgumentException
    "array values are too small" | [0]                                             | IllegalArgumentException
    "array values are too large" | [SolutionIterateIt.UPPER_BOUND_ARRAY_VALUE + 1] | IllegalArgumentException
  }

  @Unroll
  void "When the #description then #expectedRepCount is returned"() {
    when:
    int repCount = SolutionIterateIt.iterateIt(input as int[])
    then:
    repCount == expectedRepCount
    where:
    description                    | expectedRepCount | input
    "count terminates"             | 4                | [1, 3, 4]
    "count terminates on one loop" | 1                | [3, 3, 3]
    "count terminates on one loop" | 1                | [3, 3, 3, 3, 3, 3]
    "count terminates on one loop" | 1                | [1, 1, 1, 1, 1, 1, 1]
    "count terminates on one loop" | 1                | [SolutionIterateIt.UPPER_BOUND_ARRAY_VALUE, SolutionIterateIt.UPPER_BOUND_ARRAY_VALUE, SolutionIterateIt.UPPER_BOUND_ARRAY_VALUE]
    "small input both ends"        | 2                | [1, SolutionIterateIt.UPPER_BOUND_ARRAY_VALUE]
    "small input both ends"        | 2                | [3, 50, 3, 50]
  }

}

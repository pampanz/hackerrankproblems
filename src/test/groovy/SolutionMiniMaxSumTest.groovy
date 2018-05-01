import spock.lang.Specification
import spock.lang.Unroll

class SolutionMiniMaxSumTest extends Specification {

  @Unroll
  void "When an array is #description then error is thrown"() {
    when:
    SolutionMiniMaxSum.miniMaxSumAsString(input as int[])

    then:
    thrown(expected)

    where:
    description       | input                               | expected
    "too short"       | [1, 2, 3, 4]                        | IllegalArgumentException
    "too short"       | []                                  | IllegalArgumentException
    "too long"        | [1, 2, 3, 4, 5, 6]                  | IllegalArgumentException
    "value too small" | [1, -22, 3, 4, 5]                   | IllegalArgumentException
    "value too large" | [1, (Math.pow(10, 9) + 1), 3, 4, 5] | IllegalArgumentException
  }

  @Unroll
  void "When a valid array is given then min is #min and max is #max"() {
    when:
    String answer = SolutionMiniMaxSum.miniMaxSumAsString(input as int[])

    then:
    answer == expected

    where:
    min                   | max                     | input                                                                                 | expected
    "10"                  | "14"                    | [1, 2, 3, 4, 5]                                                                       | "10 14"
    "10"                  | "14"                    | [5, 2, 1, 4, 3]                                                                       | "10 14"
    "4"                   | "4"                     | [1, 1, 1, 1, 1]                                                                       | "4 4"
    "max allowed times 4" | "max allowed time four" | [Math.pow(10, 9), Math.pow(10, 9), Math.pow(10, 9), Math.pow(10, 9), Math.pow(10, 9)] | "4000000000 4000000000"
    "max allowed times 4" | "max allowed time four" | [1, 2, 3, 4, Math.pow(10, 9)]                                                         | "10 1000000009"

  }
}

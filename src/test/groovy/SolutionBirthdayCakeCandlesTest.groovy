import spock.lang.Specification
import spock.lang.Unroll

class SolutionBirthdayCakeCandlesTest extends Specification {

  @Unroll
  void "When invalid #description then #exception is thrown"() {
    when:
    SolutionBirthdayCakeCandles.birthdayCakeCandles(totalCandles as int, heightList as int[])

    then:
    thrown(result)
    where:
    description                  | totalCandles        | heightList               | result
    "number of candles"          | 0                   | [1]                      | IllegalArgumentException
    "height value"               | 1                   | [0]                      | IllegalArgumentException
    "entries on height array"    | 2                   | [0]                      | IllegalArgumentException
    "height too high"            | 2                   | [Math.pow(10, 7) + 1, 1] | IllegalArgumentException
    "number of candles too high" | Math.pow(10, 5) + 1 | [1, 2, 3, 4]             | IllegalArgumentException
  }

  @Unroll
  void "When the candles are #descripton"() {
    when:
    int answer = SolutionBirthdayCakeCandles.birthdayCakeCandles(totalCandles as int, heightList as int[])
    then:
    answer == expected
    where:
    description                    | totalCandles | heightList                               | expected
    "only one"                     | 1            | [1]                                      | 1
    "two of same height"           | 2            | [1, 1]                                   | 2
    "the example on the problem"   | 4            | [3, 2, 1, 3]                             | 2
    "all of the same height"       | 4            | [3, 3, 3, 3]                             | 4
    "height is on the upper limit" | 4            | [Math.pow(10, 7), 3, Math.pow(10, 7), 3] | 2
    "height is on the lower limit" | 4            | [1, 1, 1, 1,]                            | 4
  }
}

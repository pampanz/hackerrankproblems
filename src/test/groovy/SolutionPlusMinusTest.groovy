import spock.lang.Specification
import spock.lang.Unroll

class SolutionPlusMinusTest extends Specification {

  void "When an empty array is given then zero is returned"() {
    given:
    int[] input = []

    when:
    BigDecimal[] output = SolutionPlusMinus.plusMinusCalculation(input)

    then:
    output == [0, 0, 0] as BigDecimal[]
  }

  @Unroll
  void "When the a valid array on #description is provided the correct output array is returned"() {

    when:
    BigDecimal[] output = SolutionPlusMinus.plusMinusCalculation(input as int[])

    then:
    output == expected

    where:

    input                                    | expected                                         | description
    [-4, 3, -9, 0, 4, 1]                     | ([0.500000, 0.333333, 0.166667] as BigDecimal[]) | "problem example"
    [-4, 3, -9, 0, 4, 1, -1, -1, -1, -1, -1] | ([0.272727, 0.636364, 0.0909091] as BigDecimal[]) | "more values"
  }

  void "When the a valid array is provided the correct output String is returned"() {
    given:
    int[] input = [-4, 3, -9, 0, 4, 1]

    when:
    String output = SolutionPlusMinus.plusMinusAsString(input)

    then:
    output == """0.5
0.333333
0.166667
"""
  }
}

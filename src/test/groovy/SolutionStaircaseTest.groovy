import spock.lang.Specification
import spock.lang.Unroll

class SolutionStaircaseTest extends Specification {

  @Unroll
  void "Given a #description then right step is returned"() {
    when:
    String output = SolutionStaircase.step(size, step)
    then:
    output == expected

    where:
    description                     | size | step | expected
    "zero length"                   | 0    | 0    | ""

    "length of one"                 | 1    | 0    | "#"

    "length of two"                 | 2    | 0    | "##"
    "length of two"                 | 2    | 1    | " #"

    "first step on length of four"  | 4    | 0    | "####"
    "second step on length of four" | 4    | 1    | " ###"
    "third step on length of four"  | 4    | 2    | "  ##"
    "fourth step length of four"    | 4    | 3    | "   #"

  }

  @Unroll
  void "Given a #description then right pyramid is returned"() {
    when:
    String output = SolutionStaircase.staircaseAsString(size)
    then:
    output == expected

    where:
    description      | size | expected
    "zero length"    | 0    | ""
    "length of one"  | 1    | "#"
    "length of two"  | 2    | " #\n##"
    "length of four" | 4    | "   #\n  ##\n ###\n####"
    "length of six"  | 6    | "     #\n    ##\n   ###\n  ####\n #####\n######"

  }
}

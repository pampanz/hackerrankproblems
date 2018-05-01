import spock.lang.Specification
import spock.lang.Unroll

import java.time.format.DateTimeParseException

class SolutionTimeConversionTest extends Specification {

  @Unroll
  void "Given AM/PM time then 24H time is returned"() {
    when:
    String answer = SolutionTimeConversion.timeConversion(amPmTime)
    then:
    answer == expected24H
    where:
    amPmTime     | expected24H
    "07:05:45PM" | "19:05:45"
    "12:00:00AM" | "00:00:00"
    "12:00:00PM" | "12:00:00"
  }

  @Unroll
  void "Given invalid inputs AM/PM time then exception is returned"() {
    when:
    SolutionTimeConversion.timeConversion(amPmTime)
    then:
    thrown(exception)
    where:
    amPmTime     | exception
    "13:00:00PM" | DateTimeParseException
    "07:66:00AM" | DateTimeParseException
    "07:26:66AM" | DateTimeParseException
    "07:26:66AM" | DateTimeParseException
    "00:00:00AM" | IllegalArgumentException
    "00:00:00PM" | IllegalArgumentException
    "11:00:00MM" | DateTimeParseException
  }
}

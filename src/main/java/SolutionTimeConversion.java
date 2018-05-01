// Copyright 2018 Red Energy Limited
// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SolutionTimeConversion {
  static String timeConversion(String s) {
    if (s.matches("00:.+(AM|PM)")) {
      throw new IllegalArgumentException("Invalid input time");
    }
    LocalTime amPmTime = LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa"));
    return amPmTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  }
}

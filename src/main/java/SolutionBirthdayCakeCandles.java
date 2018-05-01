// Copyright 2018 Red Energy Limited
// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;

public class SolutionBirthdayCakeCandles {

  static void validateNumberOfCandles(int n) {
    if (n < 1) {
      throw new IllegalArgumentException("The number of candles cannot be less than 1");
    }
    if (n > Math.pow(10, 5)) {
      throw new IllegalArgumentException("The number of candles cannot be more than 10^5");
    }
  }

  static void validateCandleHeight(int[] ar) {
    for (int i = 0; i < ar.length; i++) {
      int value = ar[i];
      if (value < 1) {
        throw new IllegalArgumentException("The candle height cannot be less than 1");
      }
      if (value > Math.pow(10, 7)) {
        throw new IllegalArgumentException("The candle height cannot be more than 10^7");
      }
    }
  }

  static int birthdayCakeCandles(int n, int[] ar) {
    validateNumberOfCandles(n);
    validateCandleHeight(ar);
    if (n != ar.length) {
      throw new IllegalArgumentException("The number of elements on the list of heights is different to number of candles");
    }

    int answer = 0;

    Optional<BigInteger> max = Arrays
      .stream(ar)
      .mapToObj(String::valueOf)
      .map(BigInteger::new)
      .max(BigInteger::compareTo);
    if (max.isPresent()) {
      long count = Arrays
        .stream(ar)
        .mapToObj(String::valueOf)
        .map(BigInteger::new)
        .filter(value -> value.compareTo(max.get()) == 0)
        .count();
      answer += count;
    }

    return answer;
  }
}

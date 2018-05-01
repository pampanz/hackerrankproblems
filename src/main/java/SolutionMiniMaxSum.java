// Copyright 2018 Red Energy Limited
// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class SolutionMiniMaxSum {


  private static void validateInput(int[] arr) {
    int length = arr.length;
    if (length != 5) {
      throw new IllegalArgumentException("The length of the array is unexpected: " + length);
    }
    for (int i = 0; i < length; i++) {
      long value = arr[i];
      if (value < 1) {
        throw new IllegalArgumentException("The value on position: " + i + " of: " + value + " is too small");
      }
      if (value > Math.pow(10, 9)) {
        throw new IllegalArgumentException("The value on position: " + i + " of: " + value + " is too large");
      }
    }
  }

  private static Stream<BigInteger> asSortedBigIntegerStream(int[] arr) {
    Stream<BigInteger> sorted = Arrays
      .stream(arr)
      .mapToObj(String::valueOf)
      .map(value -> {
          BigInteger newValue = new BigInteger(value);
          return newValue;
        }
      )
      .sorted();
    return sorted;
  }

  static String miniMaxSumAsString(int[] arr) {
    validateInput(arr);
    Stream<BigInteger> sorted = asSortedBigIntegerStream(arr);
    BigInteger minimum = sorted.limit(4).reduce(
      BigInteger::add
    ).get();
    sorted = asSortedBigIntegerStream(arr);
    BigInteger maximum = sorted.skip(1).reduce(
      BigInteger::add
    ).get();

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(minimum);
    stringBuilder.append(" ");
    stringBuilder.append(maximum);
    return stringBuilder.toString();
  }

  static void miniMaxSum(int[] arr) {
    System.out.println(miniMaxSumAsString(arr));
  }
}

// Copyright 2018 Red Energy Limited
// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionIterateIt {
  static final double UPPER_BOUND_ARRAY_VALUE = Math.pow(10, 4) * 5;
  private static final double MAX_ELEMENTS_IN_ARRAY = Math.pow(10, 5);
  private static final BigInteger NEGATIVE = new BigInteger("-1");

  static int iterateIt(int[] a) {
    validate(a);
    int rep = 0;
    List<BigInteger> input = Arrays.stream(a).mapToObj(String::valueOf).map(BigInteger::new).collect(Collectors.toList());

    while (!input.isEmpty()) {
      List<BigInteger> absoluteDifferences = new ArrayList<>();
      for (int i = 0; i < input.size(); i++) {
        BigInteger value1 = input.get(i);
        List<BigInteger> restOfList = new ArrayList<>(input);
        restOfList.remove(i);
        for (int j = i; j < restOfList.size(); j++) {
          BigInteger value2 = restOfList.get(j);
          if (value1.compareTo(value2) != 0) {
            absoluteDifferences.add(absOfMinus(value1, value2));
          }
        }
      }
      input = absoluteDifferences;
      rep++;
    }

    return rep;
  }

  private static BigInteger absOfMinus(BigInteger value1, BigInteger value2) {
    return value1.add(value2.multiply(NEGATIVE)).abs();
  }

  private static void validate(int[] a) {
    long length = a.length;
    if (length > MAX_ELEMENTS_IN_ARRAY || length < 1) {
      throw new IllegalArgumentException("Array size is not valid");
    }
    for (int i = 0; i < length; i++) {
      int value = a[i];
      if (value < 1 || value > UPPER_BOUND_ARRAY_VALUE) {
        throw new IllegalArgumentException("Array value is too small");
      }
    }
  }
}

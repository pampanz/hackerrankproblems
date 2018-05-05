// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


import java.util.ArrayList;
import java.util.List;

public class SolutionIterateIt {
  static final double UPPER_BOUND_ARRAY_VALUE = Math.pow(10, 4) * 5;
  private static final double MAX_ELEMENTS_IN_ARRAY = Math.pow(10, 5);

  static int iterateIt(int[] a) {
    validate(a);
    int rep = 0;

    while (a.length > 0) {
      List<Integer> absoluteDifferences =  new ArrayList<>();
      for (int i = 0; i < a.length; i++) {
        int value1 = a[i];
        for (int j = 0; j < a.length; j++) {
          if (j != i) {
            int value2 = a[j];
            if (value1 != value2) {
              absoluteDifferences.add(absOfMinus(value1, value2));
            }
          }
        }
      }
      if(absoluteDifferences.isEmpty()) {
        a = new int[0];
      } else {
        a = absoluteDifferences.stream().mapToInt(i -> i).toArray();
      }
      rep++;
    }

    return rep;
  }

  private static int absOfMinus(int value1, int value2) {
    return Math.abs(value1 - value2);
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

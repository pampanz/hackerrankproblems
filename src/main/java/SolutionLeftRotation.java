// Copyright 2018 Red Energy Limited
// Pablo Sosa (psosa_ar@yahoo.com)
// 3/05/18


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionLeftRotation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int a[] = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    System.out.println(leftRotate(k, n, a));
  }

  static void validateInput(int numberOfLeftRotations, int inputLength, int[] input) {
    if (inputLength < 1 || inputLength > Math.pow(10, 5)) {
      throw new IllegalArgumentException("Array size outside constraints[1:100000]");
    }
    if (inputLength != input.length) {
      throw new IllegalArgumentException("Array length: " + inputLength + " different to array length" + input.length);
    }
    if (numberOfLeftRotations < 1 || numberOfLeftRotations > inputLength) {
      throw new IllegalArgumentException("Number of left rotations is outside constraints [1:" + inputLength + "]");
    }

    for (int i = 0; i < inputLength; i++) {
      int value = input[i];
      if (value < 1 || value > Math.pow(10, 6)) {
        throw new IllegalArgumentException("Array size outside constraints[1:1000000]");
      }
    }
  }

  static String leftRotate(int leftRotation, int inputLength, int[] input) {
    validateInput(leftRotation, inputLength, input);
    StringBuilder answer = new StringBuilder();
    List<Integer> integers = Arrays.stream(input).boxed().collect(Collectors.toList());
    for (int i = 0; i < leftRotation; i++) {
      integers.add(integers.get(i));
    }
    integers.stream().skip(leftRotation).forEachOrdered(value -> {
      answer.append(value);
      answer.append(" ");
    });

    return answer.toString().trim();
  }
}

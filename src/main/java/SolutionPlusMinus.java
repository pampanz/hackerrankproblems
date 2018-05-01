// Copyright 2018 Red Energy Limited
// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


import java.math.BigDecimal;
import java.math.MathContext;

public class SolutionPlusMinus {

  static BigDecimal[] plusMinusCalculation(int[] arr) {
    double total = arr.length;
    int positiveValues = 0;
    int negativeValues = 0;
    int zeroValues = 0;

    for (int i = 0; i < total; i++) {
      int value = arr[i];
      positiveValues += (value > 0 ? 1 : 0);
      negativeValues += (value < 0 ? 1 : 0);
      zeroValues += (value == 0 ? 1 : 0);
    }

    BigDecimal[] answer = new BigDecimal[3];
    if (total > 0) {
      BigDecimal positiveFraction = new BigDecimal(positiveValues / total);
      BigDecimal negativeFraction = new BigDecimal(negativeValues / total);
      BigDecimal zeroesFraction = new BigDecimal(zeroValues / total);
      answer[0] = positiveFraction.round(new MathContext(6));
      answer[1] = negativeFraction.round(new MathContext(6));
      answer[2] = zeroesFraction.round(new MathContext(6));
    }
    else {
      answer[0] = BigDecimal.ZERO;
      answer[1] = BigDecimal.ZERO;
      answer[2] = BigDecimal.ZERO;
    }
    return answer;
  }

  static String plusMinusAsString(int[] arr) {
    StringBuffer stringBuffer = new StringBuffer();
    BigDecimal[] answer = plusMinusCalculation(arr);
    for (int i = 0; i < answer.length; i++) {
      stringBuffer.append(answer[i]);
      stringBuffer.append("\n");
    }
    return stringBuffer.toString();
  }

  static void plusMinus(int[] arr) {
    System.out.println(plusMinusAsString(arr));
  }
}

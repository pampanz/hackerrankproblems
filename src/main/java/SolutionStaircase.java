// Pablo Sosa (psosa_ar@yahoo.com)
// 1/05/18


public class SolutionStaircase {

  private final static String STAIR_CHAR = "#";
  private final static String STAIR_SPACE = " ";

  static String step(int length, int number) {
    int stepFillings = length - number;

    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < number; i++) {
      answer.append(STAIR_SPACE);
    }
    for (int i = 0; i < stepFillings; i++) {
      answer.append(STAIR_CHAR);
    }
    return answer.toString();
  }

  static String staircaseAsString(int n) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = n - 1; i >= 0; i--) {
      stringBuffer.append(step(n, i));
      if (i > 0) {
        stringBuffer.append("\n");
      }
    }
    return stringBuffer.toString();
  }

  static void staircase(int n) {
    System.out.println(staircaseAsString(n));
  }

}

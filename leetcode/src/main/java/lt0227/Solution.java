package lt0227;

/**
 * Created by Anderson on 2021/3/1
 */
public class Solution {
  public int calculate(String s) {
    int[] dArray = new int[]{0, 0, 0};
    int dIndex = -1;
    char opArray[] = new char[2];
    int opIndex = -1;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        dIndex++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          dArray[dIndex] = dArray[dIndex] * 10 + (s.charAt(i) - 48);
          i++;
        }
        i--;
      } else if (c == ' ') {
        continue;
      } else {
        if (opIndex == -1) {
          opArray[++opIndex] = c;
        } else if (getPriority(c) > getPriority(opArray[opIndex])) {
          opIndex++;
          opArray[opIndex] = c;
        } else {
          while (opIndex >= 0 && getPriority(c) <= getPriority(opArray[opIndex])) {
            char op = opArray[opIndex];
            int value;
            if (op == '+') {
              value = dArray[dIndex - 1] + dArray[dIndex];
            } else if (op == '-') {
              value = dArray[dIndex - 1] - dArray[dIndex];
            } else if (op == '*') {
              value = dArray[dIndex - 1] * dArray[dIndex];
            } else {
              value = dArray[dIndex - 1] / dArray[dIndex];
            }
            opIndex--;
            dArray[dIndex] = 0;
            dIndex--;
            dArray[dIndex] = value;
          }
          opArray[++opIndex] = c;
        }
      }
    }

    while (opIndex >= 0) {
      char op = opArray[opIndex];
      int value;
      if (op == '+') {
        value = dArray[dIndex - 1] + dArray[dIndex];
      } else if (op == '-') {
        value = dArray[dIndex - 1] - dArray[dIndex];
      } else if (op == '*') {
        value = dArray[dIndex - 1] * dArray[dIndex];
      } else {
        value = dArray[dIndex - 1] / dArray[dIndex];
      }
      dIndex--;
      opIndex--;
      dArray[dIndex] = value;
    }

    return dArray[0];
  }

  public static int getPriority(char c) {
    switch (c) {
      case '+':
      case '-':
        return 0;
      case '*':
      case '/':
        return 1;
      default:
        throw new IllegalArgumentException();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.calculate("3+2*2"));
    System.out.println(solution.calculate(" 3/2 "));
    System.out.println(solution.calculate(" 3+5 / 2 "));
    System.out.println(solution.calculate("1+1+1"));
  }
}

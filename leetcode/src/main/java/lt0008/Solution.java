package lt0008;

/**
 * Created by Anderson on 2021/3/13
 */
public class Solution {
  public int myAtoi(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int i = 0;
    int length = s.length();
    boolean positive = true;
    while (i < length) {
      if (s.charAt(i) == ' ') {
        i++;
      } else {
        break;
      }
    }

    if (i == length) {
      return 0;
    } else if (s.charAt(i) == '-') {
      positive = false;
      i++;
    } else if (s.charAt(i) == '+') {
      i++;
    }

    int result = 0;
    int limit = 214748364; // Integer.MAX = 2147483647 Integer.MIN = -2147483648
    for (; i < length; i++) {
      char c = s.charAt(i);
      if (c < '0' || c > '9') { // if(!Character.isDigit(c))
        break;
      }
      int value = c - '0';
      if (result >= limit) {
        if (positive) {
          if (result > limit) {
            return Integer.MAX_VALUE;
          } else if (value > 7) {
            return Integer.MAX_VALUE;
          }
        } else if (!positive) {
          if (result > limit) {
            return Integer.MIN_VALUE;
          } else if (value > 8) {
            return Integer.MIN_VALUE;
          }
        }
      }
      result = result * 10 + value;
    }

    if (!positive) {
      return result * (-1);
    } else {
      return result;
    }
  }

  public static void main(String[] args) {
    int a= 10;
//    System.out.println(-a);
    a = 128;
//    System.out.println(a & 1);
    a= 127;
//    System.out.println(a & 1);
    System.out.println(0 & (-1));
    Solution solution = new Solution();
//    System.out.println(solution.myAtoi("42"));
//    System.out.println(solution.myAtoi("    -42"));
//    System.out.println(solution.myAtoi("4193 with words"));
//    System.out.println(solution.myAtoi("words and 987"));
//    System.out.println(solution.myAtoi("-91283472332"));
//    System.out.println(solution.myAtoi("1"));
    System.out.println(solution.myAtoi("21474836460"));
    System.out.println(solution.myAtoi("2147483647"));
    System.out.println(solution.myAtoi("2147483646"));
    System.out.println(solution.myAtoi("2147483648"));
    System.out.println(solution.myAtoi("-2147483647"));
    System.out.println(solution.myAtoi("-2147483648"));
    System.out.println(solution.myAtoi("-2147483649"));
  }
}

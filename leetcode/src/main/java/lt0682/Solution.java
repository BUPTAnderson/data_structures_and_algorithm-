package lt0682;

/**
 * Created by Anderson on 2021/3/2
 */
public class Solution {
  public int calPoints(String[] ops) {
    int[] numStack = new int[1000];
    int stackIndex = -1;
    for (String op : ops) {
      if (op.equals("C")) {
        stackIndex--;
      } else if (op.equals("D")) {
        int num = numStack[stackIndex];
        numStack[++stackIndex] = num * 2;
      } else if (op.equals("+")) {
        int num1 = numStack[stackIndex];
        int num2 = numStack[stackIndex - 1];
        numStack[++stackIndex] = num1 + num2;
      } else {
        numStack[++stackIndex] = Integer.valueOf(op);
      }
    }

    int result = 0;
    while (stackIndex >= 0) {
      result += numStack[stackIndex--];
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] strs = new String[] {"5","2","C","D","+"};
    System.out.println(solution.calPoints(strs));
    strs = new String[]{"5","-2","4","C","D","9","+","+"};
    System.out.println(solution.calPoints(strs));
    strs = new String[]{"1"};
    System.out.println(solution.calPoints(strs));
  }
}

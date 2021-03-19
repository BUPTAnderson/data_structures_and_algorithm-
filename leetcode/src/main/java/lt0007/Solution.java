package lt0007;

/**
 * Created by Anderson on 2021/3/13
 */
public class Solution {
  // 没有使用long型
  public int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int remainder = x % 10;
      int newResult = result * 10 + remainder;
      if ((newResult - remainder) / 10 != result) {
        return 0;
      }
      result = newResult;
      x = x / 10;
    }
    return result;
  }

  public int reverse2(int x) {
    long result = 0;
    while (x != 0) {
      result = result * 10 + (x % 10);
      x = x / 10;
    }
    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      return 0;
    } else {
      return (int) result;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverse(123));
  }
}

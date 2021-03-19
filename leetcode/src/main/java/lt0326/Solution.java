package lt0326;

/**
 * Created by Anderson on 2021/3/14
 */
public class Solution {
  // 解题思路：
  // 假设A是3的n次幂 如果 A % x == 0, 则x也是3的幂(假设x=3^m)
  // A % x = 3^n % 3^m => (3^n) / (3^m) = 3^(n-m) 可以整除，所以A % x == 0
  // 这里n是整数，A应该选择int里面3的幂最大的那个数
  public boolean isPowerOfThree(int n) {
    return (n > 0) && (1162261467 % n == 0);
  }

  public static void main(String[] args) {
    int d = (int) (Math.log(Integer.MAX_VALUE) / Math.log(3));
    System.out.println(d);
    int max = (int) Math.pow(3, d); // 1162261467
    System.out.println(max);

    Solution solution = new Solution();
    System.out.println(solution.isPowerOfThree(27));
  }
}

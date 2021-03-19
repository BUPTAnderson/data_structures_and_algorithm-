package lt0231;

/**
 * 判断是否是2的幂
 * 输入 -2^(31) <= n <= 2^(31) - 1
 *
 * 判断是否是4的幂 lt0342
 *
 * 判断是否是3的幂 lt0326
 *
 * 判断
 * Created by Anderson on 2021/3/14
 */
public class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) return false;
    return (n & (n - 1)) == 0;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPowerOfTwo(1));
    System.out.println(solution.isPowerOfTwo(16));
    System.out.println(solution.isPowerOfTwo(3));
    System.out.println(solution.isPowerOfTwo(4));
    System.out.println(solution.isPowerOfTwo(5));
    System.out.println(solution.isPowerOfTwo(0));
    System.out.println(solution.isPowerOfTwo(-1));
  }
}

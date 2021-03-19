package lt0342;

/**
 * Created by Anderson on 2021/3/14
 */
public class Solution {
  public boolean isPowerOfFour(int n) {
    // (n & (n -1)) == 0保证是2的幂
    // n & 0xAAAAAAAA) == 0 过滤掉2 、8 、32这些， 因为
    //        1  ---- 1
    //      1 0  ---- 2
    //    1 0 0  ---- 4
    //  1 0 0 0  ---- 8
    //1 0 0 0 0  ---- 16
    //  1 0 1 0  ----> A 正好可以过滤掉这些2的幂但不是4的幂
    //  0 1 0 1  ----> 5 和5与是1
      return (n > 0) && ((n & (n -1)) == 0) && ((n & 0xAAAAAAAA) == 0);
//      return (n > 0) && ((n & (n -1)) == 0) && ((n & 0x55555555) == 1);
  }

  // 是否是4的幂 首先是2的幂，并且二进制长度是奇数
  public boolean isPowerOfFour2(int n) {
    if (n <= 0) return false;
    int i = 0;
    boolean powerOfTwo = (n & (n - 1)) == 0;
    if (powerOfTwo) {
      while (n > 0) {
        n = n >>> 1;
        i++;
      }
    } else {
      return false;
    }
    return (i % 2) == 1;
  }


  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPowerOfFour2(16));
    System.out.println(solution.isPowerOfFour2(5));
    System.out.println(solution.isPowerOfFour2(1));
    System.out.println(solution.isPowerOfFour2(0));
    System.out.println(solution.isPowerOfFour2(-1));
    System.out.println(solution.isPowerOfFour2(256));
  }
}

package lt0191;

/**
 * Created by Anderson on 2021/3/14
 */
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count += (n & 1);
      n = n >>> 1;
    }

    return count;
  }

  // ***x & (x - 1)***就是将二进制x的最后一个1置为0，如2015的二进制为11111011111，则进行一次 x & (x - 1) 运算后x的值变为11111011110
  public int hammingWeight2(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n -1);
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.hammingWeight2(0b00000000000000000000000000001011));
    System.out.println(solution.hammingWeight2(0b00000000000000000000000010000000));
    System.out.println(solution.hammingWeight2(0b11111111111111111111111111111101));
  }
}

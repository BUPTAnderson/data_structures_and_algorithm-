package lt0190;

/**
 * Created by Anderson on 2021/3/14
 */
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    if (n == 0) {
      return 0;
    }
    int tmp;
    int value = 0;
    // 把移除的数添加到value后面，value不停的左移。还可以优化一下，(value << 1) ^ tmp 实际是：(value << 1) + tmp ， tmp是0/1都可以
    for (int i = 0; i < 32; i++) {
      if (n == 0) {
        value = (value << 1);
      } else {
        tmp = n & 1;
        n = n >> 1;
        value = (value << 1) ^ tmp;
      }
    }

    return value;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverseBits(0b00000010100101000001111010011100));
    System.out.println(Integer.toBinaryString(solution.reverseBits(0b11111111111111111111111111111101)));
  }
}

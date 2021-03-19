package lt0258;

/**
 * Could you do it without any loop/recursion in O(1) runtime?
 *  这是一道求树根的题，什么是树根
 *  将一个正整数的各个位数相加(即横向相加)后，若加完后的值大于等于10的话，则继续将各位数进行横向相加直到其值小于十为止所得到的数，即为树根。
 *  公式法求树根：
 *  a的树根b=(a-1)%9 +1, 集mod(a-1, 9) + 1
 *
 *  怎么来的？
 *  ab % 9 = (9a + a + b) % 9 = (a + b) % 9
 *  abc % 9 = (99a + 9b + a + b + c) % 9 = (a + b + c)%9
 *  你可能想a+b+c可能大于10，假设a+b+c=xy  xy % 9 = (9x + (x+y)) % 9
 *  所以对9取余就能得到树根，但是要考虑特殊情况 9 的树根还是9， 所以做下变形 a的树根(a-1)%9 + 1
 *
 *
 * Created by Anderson on 2021/3/16
 */
public class Solution {
  public int addDigits(int num) {
    return num == 0 ? 0 : ((num -1) % 9 + 1);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.addDigits(38));
    System.out.println(solution.addDigits(111));
    System.out.println(solution.addDigits(12345));
  }
}

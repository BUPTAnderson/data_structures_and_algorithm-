package lt0172;

/**
 * 判断一个数的阶乘的末尾有几个0
 *
 *  很多人下意识就会想到，我们先把这个阶乘的结果计算出来，然后看一下末尾有多少个0不就行了吗？但是阶乘的结果一般会比较大，很容易就会越界的，所以这个方法是不可行的。
 *
 * 思路：能产生0的质数组合只有2*5，然后问题就转变成了对N!进行质数分解(N!= x * y * z * (2*5) * (2*5) ... )后，一共有几个5，因为2的个数显然多于5。
 * 比如计算25!的末尾0的个数，包含5的数有5,10,15,20,25,其中25中包含两个5，所以一共包含6个5,25!的末尾有6个0.
 *
 * 更好的思路见方法trailingZeroes2
 * Created by Anderson on 2021/3/14
 */
public class Solution {
  public int trailingZeroes(int n) {
    if (n == 0) {
      return 0;
    }
    int count = 0;
    int i = 5;
    while (i <= n) {
      int tmp = i;
      while (tmp % 5 == 0) {
        count++;
        tmp /= 5;
      }
      i += 5;
    }

    return count;
  }

  /**
   * 首先，我们拿到这个问题的第一个想法，0是哪里来的？这个0肯定是2*5得来的。那么问题就归结于有多少对2和5。经过简单的思考我们就可以得出这里面肯定是5的个数少一些。那么这个问题就转化了呀！就转化成了从1到这个数的这个数列。里面一共有多少个因子5。
   *     那么我们首先将从1到n这个数列列一下！1，2，3，4，5，6，7，8，9，10，11，12 …….n。如果这个数可以提供5这个因子那么就说明这个数一定是5的倍数。所有可以被5整除的可以提供一个5。所有可以被25整除的都可以提供2个5。那么计算5的个数也就简单了。
   *     我们计算的时候，一直到5^m>n，就可以了。因为所有可以被25整除的都是可以被5整除的所以计算过一次了。所以25提供的2个5已经被计算过一次了。
   *     结果sum=n/5 + n/(5^2) + n/53 + …… + n/5m
   *     // n/5      ----- 计算 1, 2, 3, 4, 5 ... n 里面有多少个5的倍数
   *     // n/(5^2)  ----- 计算 1, 2, 3, 4, 5 ... n 里面有多少个25的倍数(因为25包含2个5， 直观理解应该是 n/(5^2) *2 因为25包含2个5， 但是我们计算n/5的时候已经计算过一次25了，所以这里只需 n/(5^2)), 同理下面的n/(5^3)也是直接加即可
   *     // n/(5^2)  ----- 计算 1, 2, 3, 4, 5 ... n 里面有多少个125的倍数
   *     .........
   *     // n/(5^m)  ----- 计算 1, 2, 3, 4, 5 ... n 里面有多少个5^m的倍数
   *
   *     那么代码也就很好写了吧！
   *
   * @param n
   * @return
   */
  public int trailingZeroes2(int n) {
    int count = 0;
    while (n > 0) {
      count += n / 5;
      n /= 5;
    }

    return count;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
//    System.out.println(solution.trailingZeroes(3));
//    System.out.println(solution.trailingZeroes(5));
    System.out.println(solution.trailingZeroes(10));
    System.out.println(solution.trailingZeroes(30));
  }
}

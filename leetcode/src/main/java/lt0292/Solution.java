package lt0292;

/**
 * 巴什博弈（Bash Game，同余理论）：只有一堆n个物品，两个人轮流从这堆物品中取物，规定每次至少取一个，最多取m个。最后取光者得胜。
 *
 *     显然，如果n=m+1，那么由于一次最多只能取m个，所以，无论先取者拿走多少个，后取者都能够一次
 *
 * 拿走剩余的物品，后者取胜。因此我们发现了如何取胜的法则：如果n=（m+1）r+s，（r为任意自然数，s
 *
 * ≤m),那么先取者要拿走s个物品，如果后取者拿走k（≤m)个，那么先取者再拿走m+1-k个，结果剩下
 *
 * （m+1）（r-1）个，以后保持这样的取法，那么先取者肯定获胜。总之，要保持给对手留下（m+1）的倍
 *
 * 数，就能最后获胜。
 *     这个游戏还可以有一种变相的玩法：两个人轮流报数，每次至少报一个，最多报十个，谁能报到100
 *
 * 者胜。
 *
 * https://www.cnblogs.com/BlogLwc/p/5912156.html
 *
 * Created by Anderson on 2021/3/17
 */
public class Solution {
  public boolean canWinNim(int n) {
    return (n % 4 != 0);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.canWinNim(4));
    System.out.println(solution.canWinNim(1));
    System.out.println(solution.canWinNim(2));
  }
}

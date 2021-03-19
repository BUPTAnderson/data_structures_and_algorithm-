package lt0268;

/**
 * Created by Anderson on 2021/3/16
 */
public class Solution {
  public int missingNumber(int[] nums) {
    int sum = (nums.length + 1) * nums.length / 2;
    int value = 0;
    for (int i = 0; i < nums.length; i++) {
      value += nums[i];
    }
    return sum - value;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = new int[]{3, 0, 1};
    System.out.println(solution.missingNumber(nums));
    nums = new int[]{0, 1};
    System.out.println(solution.missingNumber(nums));
    nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
    System.out.println(solution.missingNumber(nums));
    System.out.println(solution.missingNumber(nums));
    nums = new int[]{0};
    System.out.println(solution.missingNumber(nums));
  }
}

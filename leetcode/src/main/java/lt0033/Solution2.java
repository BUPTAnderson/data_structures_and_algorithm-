package lt0033;

/**
 * 1. 通过二分查找找到循环有序数组的最小值索引index 复杂度logn
 * 2. 对循环数组进行二分查找(循环数组看做是一个有序数组整体向右移动了index位)
 * Created by Anderson on 2021/3/12
 */
public class Solution2 {
  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    // find the index of the smallest value using binary search.
    // Loop will terminate since mid < high, and lo or hi will shrink by at least 1.
    // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else {
        high = mid; // 这里mid有可能就是最小值，所以high = mid; 而不是high = mid - 1;
      }
    }
    // low==high is the index of the smallest value and also the number of places rotated.
    int rot = low;
    low = 0;
    high = nums.length - 1;
    // The usual binary search and accounting for rotation.
    // 与原来的二分思路一致，只不过在进行数据比较的时候应该使用(mid + rot)% nums.length这个值
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int realmid = (mid + rot) % nums.length;
      if (nums[realmid] == target) {
        return realmid;
      } else if (nums[realmid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] num = new int[]{4, 5, 6, 7, 0, 1, 2};
    System.out.println(solution.search(num, 0));
    System.out.println(solution.search(num, 3));
    num = new int[]{1};
    System.out.println(solution.search(num, 0));
    System.out.println(solution.search(num, 1));

    num = new int[]{3, 1};
    System.out.println(solution.search(num, 1));
  }
}

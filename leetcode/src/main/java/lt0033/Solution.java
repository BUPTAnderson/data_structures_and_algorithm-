package lt0033;

/**
 * 结题思路：
 *
 * 我们发现循环数组存在一个性质：以数组中间点为分区，会将数组分成一个有序数组和一个循环有序数组。
 *
 *  如果首元素小于 mid，说明前半部分是有序的，后半部分是循环有序数组；
 *  如果首元素大于 mid，说明后半部分是有序的，前半部分是循环有序的数组；
 *  如果目标元素在有序数组范围中，使用二分查找；
 *  如果目标元素在循环有序数组中，设定数组边界后，使用以上方法继续查找。
 *
 *  时间复杂度为 O(logN)。
 * Created by Anderson on 2021/3/12
 */
public class Solution {
  public int binarySearch(int[] nums, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] > target) {
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  public int searchInArray(int[] nums, int low, int high, int target) {
    if (low <= high) {
      if (nums[low] <= nums[high]) { // 有序了直接二分查找
        return binarySearch(nums, low, high, target);
      }

      // 切分
      int mid = low + (high - low) / 2;
      if (nums[mid] >= nums[low]) { // 0 -> mid是有序数组，执行二分查找 为什么是>=而不是>,应为有可能mid和low相等，比如[3, 1] mid=0， 如果是>if是大于的话，则认为3,1是有序的，显然不对。
        int index = binarySearch(nums, low, mid, target);
        // 剩余的部分继续调用searchInArray，需要注意的是剩余的部分可能也是有序的了比如[4， 5， 6， 1， 2] => [4, 5, 6] [1, 2]所以在searchInArray方法的开头我们先校验下是否有序
        return index != -1 ? index : searchInArray(nums, mid + 1, high, target);
      } else { // mid 到结尾是有序数组，执行二分查找
        int index = binarySearch(nums, mid, high, target);
        return index != -1 ? index : searchInArray(nums, low, mid - 1, target);
      }
    } else {
      return -1;
    }
  }

  public int search(int[] nums, int target) {
    return searchInArray(nums, 0, nums.length - 1, target);
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

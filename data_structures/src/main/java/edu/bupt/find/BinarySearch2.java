package edu.bupt.find;

/**
 * ###########################################
 * ########  查找第一个等于给定值的元素  ########
 * ###########################################
 * <p>
 * 查找第一个值等于给定值的元素上一节中的二分查找是最简单的一种，即有序数据集合中不存在重复的数据，我们在其中查找值等于某个给定值的数据。
 * 如果我们将这个问题稍微修改下，有序数据集合中存在重复的数据，我们希望找到第一个值等于给定值的数据，这样之前的二分查找代码还能继续工作吗？
 * 比如这样一个有序数组[1,3,4,5,6,8,8,8,11,18]，其中，a[5]，a[6]，a[7]的值都等于 8，是重复的数据。我们希望查找第一个等于 8 的数据，
 * 也就是下标是 5 的元素。
 * 如果我们用上一节课讲的二分查找的代码实现，首先拿 8 与区间的中间值 a[4]比较，8 比 6 大，于是在下标 5 到 9 之间继续查找。
 * 下标 5 和 9 的中间位置是下标 7，a[7]正好等于 8，所以代码就返回了。尽管 a[7]也等于 8，但它并不是我们想要找的第一个等于 8 的元素，
 * 因为第一个值等于 8 的元素是数组下标为 5 的元素。我们上一节讲的二分查找代码就无法处理这种情况了。
 * <p>
 * 思路：只需要在进行调节判断的时候由arr[index]=target 改成 (arr[index] = target && index == 0) || (arr[index] = target && arr[index-1] != target)
 * <p>
 * Created by Anderson on 2021/3/12
 */
public class BinarySearch2 {
  public static int binarySearch(int[] arr, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] > target) {
        high = mid - 1;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        // mid == low 不是mid == 0， 因为起始点是low，low不一定是0
        if (mid == low || arr[mid - 1] != target) {
          return mid;
        }
        high = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
  }
}

package edu.bupt.find;

/**
 *    ###########################################
 *    ######## 查找第一个大于等于给定值的元素 #######
 *    ###########################################
 *
 * Created by Anderson on 2021/3/12
 */
public class BinarySearch4 {
  public static int binarySearch(int[] arr, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] >= target) {
        // 因为是第一个大于等于给定值, 所以如果存在前一个元素，前一个应该<target
        if (mid == low || arr[mid - 1] < target) {
          return mid;
        }
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
  }
}

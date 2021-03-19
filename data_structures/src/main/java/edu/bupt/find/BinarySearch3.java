package edu.bupt.find;

/**
 * ###########################################
 * ######## 查找最后一个值等于给定值的元素 #######
 * ###########################################
 * <p>
 * Created by Anderson on 2021/3/12
 */
public class BinarySearch3 {
  public static int binarySearch(int[] arr, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] > target) {
        high = mid - 1;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        if (mid == high || arr[mid + 1] != target) {
          return mid;
        }
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

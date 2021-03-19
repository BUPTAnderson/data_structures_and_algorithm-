package edu.bupt.find;

/**
 * Created by Anderson on 2021/3/11
 */
public class BinarySearch {
  // 循环方式
  public static int binarySearch(int[] arr, int low, int high, int target) {
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] < target) {
        low = mid + 1;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  // 递归方式
  public static int binarySearchRecursion(int[] arr, int low, int high, int target) {
    if (low > high) {
      return -1;
    }

    int mid = low + (high - low) / 2;
    if (arr[mid] > target) {
      return binarySearch(arr, low, mid - 1, target);
    } else if (arr[mid] < target) {
      return binarySearch(arr, mid + 1, high, target);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 6, 13, 19, 33, 45, 65, 78};
    System.out.println(binarySearch(arr, 0, arr.length - 1, 33));
    System.out.println(binarySearchRecursion(arr, 0, arr.length - 1, 33));
  }
}

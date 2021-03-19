package edu.bupt.sort;

/**
 *     基数排序对要排序的数据是有要求的，需要可以分割出独立的“位”来比较，而且位之间有递进的关系，如果 a 数据的高位比 b 数据大，那剩下的低位就不用比较了。
 * 除此之外，每一位的数据范围不能太大，要可以用线性排序算法来排序，否则，基数排序的时间复杂度就无法做到 O(n) 了。
 * Created by Anderson on 2021/3/11
 */
public class RadixSort {
  /**
   * 基数排序
   *
   * @param arr
   */
  public static void radixSort(int[] arr) {
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    // 从个位开始，对数组arr按"指数"进行排序
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSort(arr, exp);
    }
  }

  /**
   * 计数排序-对数组按照"某个位数"进行排序
   *
   * @param arr
   * @param exp 指数
   */
  public static void countingSort(int[] arr, int exp) {
    if (arr.length <= 1) {
      return;
    }

    // 计算每个元素的个数
    int[] c = new int[10];
    for (int i = 0; i < arr.length; i++) {
      c[(arr[i] / exp) % 10]++;
    }

    // 计算排序后的位置
    for (int i = 1; i < c.length; i++) {
      c[i] += c[i - 1];
    }

    // 临时数组r，存储排序之后的结果
    int[] r = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      r[c[(arr[i] / exp) % 10] - 1] = arr[i];
      c[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = r[i];
    }
  }
}

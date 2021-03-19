package edu.bupt.sort;

/**
 * Created by Anderson on 2021/3/7
 * 原理：
 * 从第一个数据开始，与第二个数据相比较，如果第二个数据小于第一个数据，则交换两个数据的位置。
 * 指针由第一个数据移向第二个数据，第二个数据与第三个数据相比较，如果第三个数据小于第二个数据，则交换两个数据的位置。
 * 依此类推，完成第一轮排序。第一轮排序结束后，最大的元素被移到了最右面。
 * 依照上面的过程进行第二轮排序，将第二大的排在倒数第二的位置。
 * 重复上述过程，没排完一轮，比较次数就减少一次。
 */
public class BubbleSort {
  /**
   * 简单版，未进行提前结束判断
   * @param array
   * @return
   */
  public static int[] bubbleSort(int[] array) {
    if (array.length == 0) {
      return array;
    }
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int tmp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = tmp;
        }
      }
    }
    return array;
  }

  /**
   * 优化思路：
   * 当某轮冒泡操作已经没有数据交换时，说明已经达到完全有序，不用再继续执行后续的冒泡操作。
   * @param array
   * @return
   */
  public static int[] bubbleSort2(int[] array) {
    if (array.length == 0) {
      return array;
    }
    for (int i = 0; i < array.length; i++) {
      // 提前退出冒泡循环的标志位
      boolean flag = false;
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) { // 交换
          int tmp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = tmp;
          flag = true; // 表示有数据交换
        }
      }
      if (!flag) {
        break; // 没有数据交换，提前退出
      }
    }
    return array;
  }

  public static void main(String[] args) {
    int[] array = new int[]{4, 5, 6, 3, 2, 1};
    array = bubbleSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}

package edu.bupt.sort;

/**
 * Created by Anderson on 2021/3/11
 */
public class BucketSort {

  /**
   * 桶排序
   *
   * @param arr 数组
   * @param bucketSize 桶容量
   */
  public static void bucketSort(int[] arr, int bucketSize) {
    if (arr.length < 2) {
      return;
    }

    // 数组最小值
    int minValue = arr[0];
    // 数组最大值
    int maxValue = arr[1];
    // 遍历一遍数组获取最大值和最小值
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < minValue) {
        minValue = arr[i];
      } else if (arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }

    // 桶数量
    int bucketCount = (maxValue - minValue) / bucketSize + 1;
    int[][] buckets = new int[bucketCount][bucketSize]; // 每行为一个桶
    int[] indexArr = new int[bucketCount]; // 每个index里的值，对应第index桶的下一个可以插入数据的位置，起始初始值都为0

    // 将数组中值分配到各个桶里
    for (int i = 0; i < arr.length; i++) {
      int bucketIndex = (arr[i] - minValue) / bucketSize; // 该值对应的桶的索引
      if (indexArr[bucketIndex] == buckets[bucketIndex].length) { // 该桶已经满了
        ensureCapacity(buckets, bucketIndex);
      }
      buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i]; // 将数据放入对应桶的对应index位置，index之后自增
    }

    // 对每个桶进行排序，这里使用了快速排序
    int k = 0;
    for (int i = 0; i < buckets.length; i++) {
      if (indexArr[i] == 0) { // 桶为空，跳过
        continue;
      }
      quickSortC(buckets[i], 0, indexArr[i] - 1); //  这里每个桶的最后一个数据的位置未indexArr[i] - 1，因为indexArr[i]是桶i下一个数据插入位置所以减1
      for (int j = 0; j < indexArr[i]; j++) { // 排序好的数据依次插入arr中
        arr[k++] = buckets[i][j];
      }
    }
  }

  /**
   * 数组扩容
   *
   * @param buckets
   * @param bucketIndex
   */
  private static void ensureCapacity(int[][] buckets, int bucketIndex) {
    int[] tempArr = buckets[bucketIndex];
    int[] newArr = new int[tempArr.length * 2];
    for (int j = 0; j < tempArr.length; j++) {
      newArr[j] = tempArr[j];
    }
    buckets[bucketIndex] = newArr;
  }

  /**
   * 快速排序递归函数
   *
   * @param arr
   * @param p
   * @param r
   */
  private static void quickSortC(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }

    int q = partition(arr, p, r);
    quickSortC(arr, p, q - 1);
    quickSortC(arr, q + 1, r);
  }

  /**
   * 分区函数
   *
   * @param arr
   * @param p
   * @param r
   * @return 分区点位置
   */
  private static int partition(int[] arr, int p, int r) {
    int pivot = arr[r];
    int i = p;
    for (int j = p; j < r; j++) {
      if (arr[j] <= pivot) {
        swap(arr, i, j);
        i++;
      }
    }

    swap(arr, i, r);
    return i;
  }

  /**
   * 交换
   *
   * @param arr
   * @param i
   * @param j
   */
  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }

    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}

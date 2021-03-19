package edu.bupt.sort;

import java.util.Arrays;

/**
 * Created by Anderson on 2021/3/11
 *      快排的思想是这样的：如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 *  我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。经过这一步骤之后，
 *  数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 *      根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了。
 *
 // 快速排序，A是数组，n表示数组的大小
 quick_sort(A, n) {
     quick_sort_c(A, 0, n-1)
 }
 // 快速排序递归函数，p,r为下标
 quick_sort_c(A, p, r) {
     if p >= r then return

     q = partition(A, p, r) // 获取分区点, 让q点前的数据都比q位置的数据小，q点后的数据都比q位置的数据大, partiton可以采用单边扫描或者双边扫描的方式
     quick_sort_c(A, p, q-1)
     quick_sort_c(A, q+1, r)
 }
 */
public class QuickSort {
  public static void quickSort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }

    int p = partitionBilateral(a, low, high); // 获取分区节点
    quickSort(a, low, p - 1);
    quickSort(a, p + 1, high);
  }

  // 切分数组a，返回切分点的位置。 经过划分后，切分点左侧的数据都比切分的数据小，切分点右侧数据都比切分点大
  // 思路是单边扫描
  public static int partition(int[] a, int low, int high) {
    int pivot = a[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (a[j] < pivot) {
        if (i == j) {
          i++;
        } else {
          int tmp = a[j];
          a[j] = a[i];
          a[i++] = tmp;
        }
      }
    }

    // 将pivot放置到切分点
    if (i != high) {
      int tmp = a[i];
      a[i] = pivot;
      a[high] = tmp;
    }

    return i;
  }

  public static int partitionBilateral(int[] arr, int head, int tail) {
    int pivot = arr[head];
    int low = head;
    int high = tail;
    while (low < high) {
      while (low < high && arr[high] >= pivot) {
        high--;
      }
      arr[low] = arr[high];
      while (low < high && arr[low] <= pivot) {
        low++;
      }
      arr[high] = arr[low];
    }
    arr[low] = pivot;
    return low;
  }

  // 在寻找partition时采用双边扫描的思路
  public static void quickSort2(int[] a, int head, int tail) {
    if (head >= tail) {
      return;
    }

    int pivot = a[head]; // pivot这里也起到了哨兵的作用
    int low  = head;
    int high = tail;
    while (low < high) {
      while (low < high && a[high] >= pivot) { // 因为privot选择的head, 所以head/low 位置相当于空出来了，应该从右侧开始遍历，找到小于pivot的放到head/low位置处
        high--;
      }
      a[low] = a[high];

      while (low < high && a[low] <= pivot) {
        low++;
      }
      a[high] = a[low];
    }

    // 此时low == high
    a[low] = pivot;
    quickSort2(a, head, low - 1);
    quickSort2(a, high + 1, tail);
  }
  public static void main(String[] args) {
    int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
//    int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//    int a[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    quickSort(a, 0, a.length - 1);
    System.out.println("排序结果：" + Arrays.toString(a));
  }
}

package edu.bupt.sort;

import java.util.Arrays;

/**
 * Created by Anderson on 2021/3/9
 * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
 * 归并排序使用的就是分治思想。分治，顾名思义，就是分而治之，将一个大问题分解成小的子问题来解决。小的子问题解决了，大问题也就解决了。从我刚才的描述，你有没有感觉到，
 * 分治思想跟我们前面讲的递归思想很像。是的，分治算法一般都是用递归来实现的。分治是一种解决问题的处理思想，递归是一种编程技巧
 *
 // 归并排序算法, A是数组，n表示数组大小
 merge_sort(A, n) {
     merge_sort_c(A, 0, n-1)
 }

 // 递归调用函数
 merge_sort_c(A, p, r) {
     // 递归终止条件
     if p >= r  then return

     // 取p到r之间的中间位置q
     q = (p+r) / 2
     // 分治递归
     merge_sort_c(A, p, q)
     merge_sort_c(A, q+1, r)
     // 将A[p...q]和A[q+1...r]合并为A[p...r]
     merge(A[p...r], A[p...q], A[q+1...r])
 }
 */
public class MergeSort {
  public static void merge(int[] a, int low, int mid, int high) {
    int[] temp = new int[high - low + 1];
    int i = low;// 左指针
    int j = mid + 1;// 右指针
    int k = 0;
    // 把较小的数先移到新数组中
    while (i <= mid && j <= high) {
      if (a[i] < a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    // 把左边剩余的数移入数组
    while (i <= mid) {
      temp[k++] = a[i++];
    }
    // 把右边边剩余的数移入数组
    while (j <= high) {
      temp[k++] = a[j++];
    }
    // 把新数组中的数覆盖nums数组
    for (int k2 = 0; k2 < temp.length; k2++) {
      a[k2 + low] = temp[k2];
    }
  }

  // 合并(哨兵)
  public static void mergeBySentry(int[] arr, int low, int mid, int high) {
    int[] leftArr = new int[mid - low + 2];
    int[] rightArr = new int[high - mid + 1];
    int i = 0;
    for (; i <= mid - low; i++) {
      leftArr[i] = arr[low + i];
    }
    leftArr[i] = Integer.MAX_VALUE;
    for (i = 0; i < high - mid; i++) {
      rightArr[i] = arr[mid + i + 1];
    }
    rightArr[i] = Integer.MAX_VALUE;

    i = 0;
    int j = 0;
    int k = low;
    while (k <= high) {
      if (leftArr[i] < rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
      }
    }
  }

  public static void mergeSort(int[] a, int low, int high) {
    int mid = low + (high - low) / 2; // 防止溢出
    if (low < high) {
      // 左边
      mergeSort(a, low, mid);
      // 右边
      mergeSort(a, mid + 1, high);
      // 左右归并
      merge(a, low, mid, high);
//      mergeBySentry(a, low, mid, high); //  带有哨兵的合并
    }
  }

  public static void main(String[] args) {
    int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
    mergeSort(a, 0, a.length - 1);
    System.out.println("排序结果：" + Arrays.toString(a));
  }
}

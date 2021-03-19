package edu.bupt.sort;

/**
 * Created by Anderson on 2021/3/7
 */
public class SelectSort {
  public static int[] selectSort(int[] array) {
    if (array.length == 0) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int tmp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = tmp;
      }
    }

    return array;
  }

  public static void main(String[] args) {
    int[] array = new int[]{4, 5, 6, 3, 2, 1};
    array = selectSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}

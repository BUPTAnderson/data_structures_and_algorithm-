package edu.bupt.sort;

/**
 * Created by Anderson on 2021/3/7
 * 原理：
 * 将指针指向某个元素，假设该元素左侧的元素全部有序，将该元素抽取出来，然后按照从右往左的顺序分别与其左边的元素比较，遇到比其大的元素便将元素右移，直到找到比该元素小的元素或者找到最左面发现其左侧的元素都比它大，停止；
 * 此时会出现一个空位，将该元素放入到空位中，此时该元素左侧的元素都比它小，右侧的元素都比它大；
 * 指针向后移动一位，重复上述过程。每操作一轮，左侧有序元素都增加一个，右侧无序元素都减少一个。
 */
public class InsertSort {
  public static int[] insertSort(int[] array) {
    if (array.length == 0) {
      return array;
    }
    for (int i = 0; i < array.length; i++) {
      int temp = array[i]; // 可以把temp提到for循环外面，只占一个空间
      //用作比较的数据
      int leftIndex = i - 1;
      while (leftIndex >= 0 && array[leftIndex] > temp) {
        //当比到最左边或者遇到比temp小的数据时，结束循环
        array[leftIndex + 1] = array[leftIndex];
        leftIndex--;
      }
      array[leftIndex + 1] = temp; //把temp放到空位上 // if (leftIndex + 1 != i) array[leftIndex + 1] = temp;
    }
    return array;
  }

  public static void main(String[] args) {
    int[] array = new int[]{4, 5, 6, 3, 2, 1};
    array = insertSort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}

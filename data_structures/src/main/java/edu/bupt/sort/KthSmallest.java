package edu.bupt.sort;

/**
 * O(n)复杂度获取数组中第K小的数
 *     我们选择数组区间 A[0...n-1]的最后一个元素 A[n-1]作为 pivot，对数组 A[0...n-1]原地分区，这样数组就分成了三部分，A[0...p-1]、A[p]、A[p+1...n-1]。
 * 如果 p+1=K，那 A[p]就是要求解的元素；如果 K>p+1, 说明第 K 大元素出现在 A[p+1...n-1]区间，我们再按照上面的思路递归地在 A[p+1...n-1]这个区间内查找。
 * 同理，如果 K<p+1，那我们就在 A[0...p-1]区间查找。
 *
 *     我们再来看，为什么上述解决思路的时间复杂度是 O(n)？第一次分区查找，我们需要对大小为 n 的数组执行分区操作，需要遍历 n 个元素。
 * 第二次分区查找，我们只需要对大小为 n/2 的数组执行分区操作，需要遍历 n/2 个元素。依次类推，分区遍历元素的个数分别为、n/2、n/4、n/8、n/16.……直到区间缩小为 1。
 * 如果我们把每次分区遍历的元素个数加起来，就是：n+n/2+n/4+n/8+...+1。这是一个等比数列求和，最后的和等于 2n-1。所以，上述解决思路的时间复杂度就为 O(n)。
 * Created by Anderson on 2021/3/11
 */
public class KthSmallest {
  public static int kthSmallest(int[] arr, int k) {
    if (arr == null || arr.length < k) {
      return -1;
    }

    // partiion
    int partition = partitionBilateral(arr, 0, arr.length - 1);
    int low = 0, high = arr.length - 1;
    while (partition + 1 != k) {
      if (partition + 1 < k) {
        low = partition + 1; // 重置low位置, 否则low位置一直是0
        partition = partitionBilateral(arr, partition + 1, high);
      } else {
        high = partition - 1; // 重置hight位置，否则high一直是arr.length - 1
        partition = partitionBilateral(arr, low, partition - 1);
      }
    }
    return arr[partition];
  }

  // 与快排中的partition一致 单边扫描
  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        if (i == j) {
          i++;
        } else {
          int tmp = arr[j];
          arr[j] = arr[i];
          arr[i++] = tmp;
        }
      }
    }

    if (i != high) {
      int tmp = arr[i];
      arr[i] = pivot;
      arr[high] = tmp;
    }

    return i;
  }

  private static int partitionBilateral(int[] arr, int head, int tail) {
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
  public static void main(String[] args) {
//    int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
    // [18, 20, 30, 46, 50, 51, 65, 77, 82, 97]
    int a[] = {1, 1, 2};
    int index = kthSmallest(a, 2);
    System.out.println(index);
  }
}

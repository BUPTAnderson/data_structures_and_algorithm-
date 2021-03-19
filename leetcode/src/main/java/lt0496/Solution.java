package lt0496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 寻找nums1中数字在nums2中后面第一个比它大的数字
 * nums1: [4,1]
 * nums2: [4,1,5,2]
 * 输出[5, 5]
 * 解释：nums1中4 在nums2中4后面第一个比它大的数字是5
 * nums1中1 在nums2中1后面第一个比它大的数字是5
 * Created by Anderson on 2021/3/2
 */
public class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] stack = new int[nums2.length];
    int index = -1;
    HashMap<Integer, Integer> num1ToValue = new HashMap<>(nums1.length);
    for (int num : nums2) {
      while (index > -1 && stack[index] < num) {
        num1ToValue.put(stack[index--], num);
      }
      stack[++index] = num;
    }

    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = num1ToValue.getOrDefault(nums1[i], -1);
    }

    return nums1;
  }

  /**
   * 网上的答案
   * @param findNums
   * @param nums
   * @return
   */
  public int[] nextGreaterElement2(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() < num)
        map.put(stack.pop(), num);
      stack.push(num);
    }
    for (int i = 0; i < findNums.length; i++)
      findNums[i] = map.getOrDefault(findNums[i], -1);
    return findNums;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] result = solution.nextGreaterElement(new int[]{4, 1}, new int[]{4, 1, 5, 2});
    for (int r : result) {
      System.out.println(r);
    }
  }
}

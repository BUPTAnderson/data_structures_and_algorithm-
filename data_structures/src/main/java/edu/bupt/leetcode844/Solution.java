package edu.bupt.leetcode844;

import java.util.LinkedList;
import java.util.List;

/**
 * S长度为m, T长度为n
 * 要求时间复杂度O(m+n),空间复杂度O(1)
 * 如果空间复杂度为O(m+n)的话，可以用栈来处理，遇到#出栈，最后比较栈中剩余是否相同
 * 空间复杂度O(1)，从后面向前比较，相同的话继续比较，遇到#则那个字符串向前走一位，
 */
public class Solution {
  public boolean backspaceCompare(String S, String T) {
    int i = S.length() -1, j = T.length() - 1, backCount;

    while (true) {
      backCount = 0;
      while (i >= 0 && (backCount > 0 || S.charAt(i) == '#')) {
        backCount += S.charAt(i) == '#' ? 1 : -1;
        i--;
      }
      backCount = 0;
      while (j >= 0 && (backCount > 0 || T.charAt(j) == '#')) {
        backCount += T.charAt(j) == '#' ? 1 : -1;
        j--;
      }

      if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
        i--;
        j--;
      } else {
        break;
      }
    }

    return i == -1 && j == -1;
  }

  public static void main(String[] args) {
  }
}

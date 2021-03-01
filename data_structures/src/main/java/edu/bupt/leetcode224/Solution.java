package edu.bupt.leetcode224;

import java.util.Stack;

/**
 * 其实这题没有出现乘法和除法，所以括号没用，扫一遍把括号和空格拿掉然后就是227题基本加减法的实现了
 */
public class Solution {
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      throw new IllegalArgumentException();
    }
    Stack<Character> opStack = new Stack<>();
    Stack<Character> numStack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (c == ' ') {
        continue;
      }

      if (c >= 48 && c <= 57) {
        numStack.push(c);
      } else if (c == ')') {
        process(opStack, numStack);
      } else {
        opStack.push(c);
      }
    }

    while (!opStack.empty()) {
      Character operate = opStack.pop();
      int n1 = numStack.pop();
      int n2 = numStack.peek();
      if (operate == '+') {
        numStack.push((char) (n1 + n2));
      } else if (operate == '-') {
        numStack.push((char) (n2 - n1));
      }
    }

    return numStack.pop();
  }

  private void process(Stack<Character> opStack, Stack<Character> numStack) {
    Character operate = opStack.pop();
    while (operate != '(') {
      int n1 = numStack.pop();
      int n2 = numStack.peek();
      if (operate == '+') {
        numStack.push((char) (n1 + n2));
      } else if (operate == '-') {
        numStack.push((char) (n2 - n1));
      }

      operate = opStack.pop();
    }
  }


  public static void main(String[] args) {
    System.out.println('A' == 65);
  }
}

package lt0224;

import java.util.Stack;

/**
 * 网上一种说法：
 * 其实这题没有出现乘法和除法，所以括号没用，扫一遍把括号和空格拿掉然后就是227题基本加减法的实现了
 * 这里其实是不对的，比如(8 + 2) - (5 - 2) 应该是7，如果直接把括号和空格去掉8+2-5-2 结果是3，显然不对
 * 这里先假定数值都是一位的
 */
public class Solution {
  /**
   * 这个是我自己的解
   * calculate2是网上更优的解
   * @param s
   * @return
   */
  public int calculate(String s) {
    Stack<Integer> operatorStack = new Stack<>(); // 操作数栈
    Stack<Character> operandStack = new Stack<>(); // 操作符栈
    int operator = 0;
    char pre = ' '; // pre是为了解决负数： "-2+ 1"  "(-2)+ 1" "2 - (-2 +3)"
    for (int i = 0; i < s.length(); i++) {
      char op = s.charAt(i);
      if (op >= '0' && op <= '9') {
        // 这里进行了一个多位数值的判断
        operator = operator * 10 + (op - 48);
        while (i + 1 < s.length()) {
          char next = s.charAt(i + 1);
          if (next >= '0' && next <= '9') {
            operator = operator * 10 + (next - 48);
            i++;
          } else {
            break;
          }
        }
        operatorStack.push(operator);
        operator = 0;
        pre = op;
      } else if (op == '+' || op == '-') {
        if (op == '-' && (pre == '(' || i == 0)) {
          operatorStack.push(0);
        }
        pre = op;
        while (!operandStack.empty() && operandStack.peek() != '(') {
          char preOp = operandStack.pop();
          int p2 = operatorStack.pop();
          int p1 = operatorStack.pop();
          if (preOp == '+') {
            operatorStack.push(p1 + p2);
          } else {
            operatorStack.push(p1 - p2);
          }
        }
        operandStack.push(op);
      } else if (op == ')') {
        pre = op;
        while (operandStack.peek() != '(') {
          char preOp = operandStack.pop();
          int p2 = operatorStack.pop();
          int p1 = operatorStack.pop();
          if (preOp == '+') {
            operatorStack.push(p1 + p2);
          } else {
            operatorStack.push(p1 - p2);
          }
        }
        operandStack.pop();
      } else if (op == '(') {
        pre = '(';
        operandStack.push(op);
      }
    }

    while (!operandStack.empty()) {
      char preOp = operandStack.pop();
      int p2 = operatorStack.pop();
      int p1 = operatorStack.pop();
      if (preOp == '+') {
        operatorStack.push(p1 + p2);
      } else {
        operatorStack.push(p1 - p2);
      }
    }
    return operatorStack.pop();
  }

  /**
   * 更优的解
   * @param s
   * @return
   */
  public int calculate2(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    int result = 0;
    int number = 0;
    int sign = 1;
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)){
        number = 10 * number + (int)(c - '0');
      }else if(c == '+'){
        result += sign * number;
        number = 0;
        sign = 1;
      }else if(c == '-'){
        result += sign * number;
        number = 0;
        sign = -1;
      }else if(c == '('){
        //we push the result first, then sign;
        stack.push(result);
        stack.push(sign);
        //reset the sign and result for the value in the parenthesis
        sign = 1;
        result = 0;
      }else if(c == ')'){
        result += sign * number;
        number = 0;
        result *= stack.pop();    //stack.pop() is the sign before the parenthesis
        result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

      }
    }
    if(number != 0) result += sign * number;
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.calculate2("1 + 1"));
    System.out.println(solution.calculate2(" 2-1 + 2 "));
    System.out.println(solution.calculate2("(1+(4+5+2)-3)+(6+8)"));
    System.out.println(solution.calculate2("(8+2)-(5-2)"));
    System.out.println(solution.calculate2("(18+2)-(5-2)"));
    System.out.println(solution.calculate2("2147483647"));
    System.out.println(solution.calculate2("-2+ 1"));
    System.out.println(solution.calculate2("(-2)+ 1"));
    System.out.println(solution.calculate2("2 - (-2 +3)"));
  }
}

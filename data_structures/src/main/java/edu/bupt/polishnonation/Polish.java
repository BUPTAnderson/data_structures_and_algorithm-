package edu.bupt.polishnonation;

import java.util.Stack;

/**
 * Created by Anderson on 2021/3/1
 * 1.前缀表达式又称波兰式，前缀表达式的运算符位于操作数之前。比如:- × + 3 4 5 6
 * 2.中缀表达式就是常见的运算表达式，如(3+4)×5-6
 * 3.后缀表达式又称逆波兰表达式,与前缀表达式相似，只是运算符位于操作数之后,比如:3 4 + 5 × 6 -
 * <p>
 * 参考：https://www.jianshu.com/p/649c12a80fe8
 */
public class Polish {
  /**
   * 通过逆波兰表达式求值
   * <p>
   * <p>
   * 我们先看一个例子...后缀表达式3 4 + 5 × 6 -的计算
   * 1.从左至右扫描，将3和4压入堆栈；
   * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素，注意与前缀表达式做比较），计算出3+4的值，得7，再将7入栈；
   * 3.将5入栈；
   * 4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
   * 5.将6入栈；
   * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果。
   * 这里假定字符串中的数值都是位数是1
   *
   * @param express
   * @return
   */
  public static int calcRevPolishNotation(String express) {
    if (express.trim().length() == 0) {
      throw new IllegalArgumentException("express: " + express + " is invalid.");
    }
    Stack<Integer> operandStack = new Stack<Integer>();
    for (int i = 0; i < express.length(); i++) {
      char c = express.charAt(i);
      if (c == ' ') {
        continue;
      }
      if (c >= '0' && c < '9') {
        operandStack.push(Utils.charParse(c));
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        operandStack.push(Utils.process(operandStack, c));
      } else {
        continue;
      }
    }

    return operandStack.pop();
  }

  /**
   * 中缀表达式转后缀表达式(逆波兰表达式)
   * <p>
   * 中缀表达式转后缀表达式主要用到了栈进行运算符处理，队列进行排序输出，规则为：
   * <p>
   * 1.数字直接入队列
   * 2.运算符要与栈顶元素比较
   * ①栈为空直接入栈
   * ②运算符优先级大于栈顶元素优先级则直接入栈
   * ③小于或等于则出栈入列，再与栈顶元素进行比较，直到运算符优先级大于栈顶元素优先级(或栈为空或栈顶为'(')后，操作符再入栈
   * 3.操作符是 ( 则无条件入栈
   * 4.操作符为 )，则依次出栈入列，直到匹配到第一个(为止，此操作符直接舍弃，(直接出栈舍弃
   * 5.表达式处理完后，如果栈不为空，依次出栈入队列，直到栈为空。
   * <p>
   * 输出队列内容即可
   *
   * @param express
   * @return
   */
  public static String transfer2PolishNonation(String express) {
    StringBuffer sb = new StringBuffer();
    Stack<Character> operand = new Stack<>();
    for (int i = 0; i < express.length(); i++) {
      char c = express.charAt(i);
      if (c == ' ') {
        continue;
      } else if (c >= '0' && c < '9') {
        sb.append(c).append(' ');
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        if (operand.empty()) { // 对应①
          operand.push(c);
          continue;
        }

        // 注意遍历的时候要判断栈是否为空切要先判空和是否为'(' 因为我们的priority方法中不会判断'('的优先级
        while (!operand.empty() && operand.peek() != '(' && Utils.priority(c) <= Utils.priority(operand.peek())) {
          sb.append(operand.pop()).append(' '); // 对应③
        }
        operand.push(c); // 对应②
      } else if (c == ')') {
        while (operand.peek() != '(') {
          sb.append(operand.pop()).append(' ');
        }
        operand.pop();
      } else if (c == '(') {
        operand.push(c);
      }
    }

    while (!operand.isEmpty()) {
      sb.append(operand.pop()).append(' ');
    }
    return sb.toString();
  }

  /**
   * 中缀表达式计算值
   *
   * @return
   */
  public static int getValueFromInfixNonation(String express) {
    if (express == null || express.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Stack<Integer> operator = new Stack<>(); // 操作数
    Stack<Character> operand = new Stack<>(); // 操作符
    for (int i = 0; i < express.length(); i++) {
      char c = express.charAt(i);
      if (c == ' ') {
        continue;
      }
      if (c > '0' && c < '9') {
        operator.push(Utils.charParse(c));
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        if (operand.isEmpty()) {
          operand.push(c);
          continue;
        }
        while (!operand.isEmpty() && operand.peek() != '(' && Utils.priority(c) <= Utils.priority(operand.peek())) {
          int value = Utils.process(operator, operand.pop());
          operator.push(value);
        }
        operand.push(c);
      } else if (c == ')') {
        while (operand.peek() != '(') {
          int value = Utils.process(operator, operand.pop());
          operator.push(value);
        }
        operand.pop();
      } else if (c == '(') {
        operand.push(c);
      }
    }

    while (!operand.isEmpty()) {
      int value = Utils.process(operator, operand.pop());
      operator.push(value);
    }

    return operator.pop();
  }

  public static void main(String[] args) {
//    String str = "(11+(44+5+21)-32)+(6+8)";
//    Pattern pattern = Pattern.compile("\\d+");
//    Matcher matcher = pattern.matcher(str);
//    while (matcher.find()) {
//      System.out.println(matcher.group());
//      System.out.println("index: " + matcher.end()); // 匹配字符串最后字符的索引
//    }

//    System.out.println(calcRevPolishNotation("3 4 + 5 * 6 -"));
//    System.out.println(transfer2PolishNonation("(3+4)*5-6"));
    System.out.println(getValueFromInfixNonation("(3+4)*5-(6 - 2 * 2) + 5"));
  }
}

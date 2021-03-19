package edu.bupt.find;

/**
 * Created by Anderson on 2021/3/11
 */
public class Sqrt {
  // 循环方式
  public static double sqrt(int target, double low, double high, double precision) {
    double mid = low + (high - low) / 2;
    double value = mid * mid;
    while ((value - target) > precision || (target - value) > precision) {
      if (value > target) {
        high = mid;
        mid = low + (mid - low) / 2;
      } else {
        low = mid;
        mid = mid + (high - mid) / 2;
      }
      value = mid * mid;
    }

    return mid;
  }

  // 递归方式
  public static double sqrtRecursion(int target, double low, double high, double precision) {
    double mid = low + (high - low) / 2;
    double value = mid * mid;
    if (value - target > precision) {
      return sqrtRecursion(target, low, mid, precision);
    } else if (target - value > precision) {
      return sqrtRecursion(target, mid, high, precision);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    // 精确到小数点后6位，比如7开根号位2.6457513，则我们要输出2.645751*** 极端情况比如正确值是1.4143509 我们可以是1.4143500，差值为0.0000009, 小于0.000001
    // 即：精确到小数点后6位，那么差值要小于1/(10^6)=0.000001
    System.out.println(sqrt(7, 0.0, 5 * 1.0, 0.000001));
    System.out.println(sqrtRecursion(7, 0.0, 5 * 1.0, 0.000001));
  }
}

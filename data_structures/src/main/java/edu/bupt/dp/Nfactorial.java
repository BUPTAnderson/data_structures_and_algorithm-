package edu.bupt.dp;

/**
 * 求N!
 */
public class Nfactorial {
  public int nfactorial(int n) {
    if (n <= 0) {
      return 0;
    }
    int[] result = new int[n + 1];
    result[0] = 1;
    for (int i = 1; i <= n; i++) {
      result[i] = i * result[i - 1];
    }

    return result[n];
  }
}

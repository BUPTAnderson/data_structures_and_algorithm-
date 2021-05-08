package edu.bupt.dp;

/**
 * N*M 棋盘，士兵从左下角走到右上角，只能向上或者向右走，问有几种走法。
 * F(n, m) = F(n-1, m) + F(n, m-1)
 */
public class NMchessboard {
  public int run(int n, int m) {
    if (n == 0 || m == 0) {
      return 1;
    }
    int[][] chessboardArray = new int[n][m];
    for (int i = 0; i < n; i++) {
      chessboardArray[i][0] = 1;
    }
    for (int j = 0; j < m; j++) {
      chessboardArray[0][m] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        chessboardArray[i][j] = chessboardArray[i - 1][j] + chessboardArray[i][j - 1];
      }
    }
    return chessboardArray[n - 1][m - 1];
  }
}

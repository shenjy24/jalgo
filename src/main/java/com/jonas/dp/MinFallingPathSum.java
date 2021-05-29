package com.jonas.dp;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below
 * or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-05-05
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        MinFallingPathSum app = new MinFallingPathSum();
        int[][] matrix = {{-19,57},{-40,-5}}; //[[-19,57],[-40,-5]]
        System.out.println(app.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }

        int[] temp = new int[n];    //临时存储中间值
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    temp[j] = Math.min(dp[j] + matrix[i][j], dp[j + 1] + matrix[i][j]);
                } else if (j == n - 1) {
                    temp[j] = Math.min(dp[j - 1] + matrix[i][j], dp[j] + matrix[i][j]);
                } else {
                    temp[j] = min(dp[j - 1] + matrix[i][j], dp[j] + matrix[i][j], dp[j + 1] + matrix[i][j]);
                }
            }
            for (int k = 0; k < n; k++) {
                dp[k] = temp[k];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[j]);
        }
        return res;
    }

    private int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}

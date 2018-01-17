package com;

/**
 * Created by chengcheng on 3/1/17.
 */
public class MaximalSquareII {
    public static void main(String[] args) {
        int[][] nums = {{1,0,1,0,0},{1,0,0,1,0},{1,1,0,0,1},{1,0,0,1,0}};
        int n = maximalSquareII(nums);
        System.out.println(n);
    }

    private static int maximalSquareII(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] f = new int[n][m];
        int [][] fv = new int[n][m];
        int[][] fh = new int[n][m];

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 1) {
                f[i][0] = 1;
                max = 1;
            } else if (i > 0) {
                fv[i][0] = fv[i - 1][0] + 1;
                fh[i][0] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 1) {
                f[0][j] = 1;
            } else if (j > 0) {
                fh[0][j] = fh[0][j - 1] + 1;
                fv[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (fv[i - 1][j] != 0 && fh[i][j - 1] != 0 && f[i - 1][j - 1] != 0) {
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(fv[i - 1][j], fh[i][j - 1])) + 1;
                        max = Math.max(f[i][j] * f[i][j], max);
                    }

                } else {
                    fv[i][j] = fv[i - 1][j] + 1;
                    fh[i][j] = fh[i][j - 1] + 1;
                }
            }
        }

        return max;
    }
}

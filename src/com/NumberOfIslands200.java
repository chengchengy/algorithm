package com;

/**
 * Created by chengcheng on 1/25/17.
 */
public class NumberOfIslands200 {
    static boolean[][] flag;
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int island = countIsland(grid);
        System.out.println(island);
    }

    private static int countIsland(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        flag = new boolean[grid.length][grid[0].length];

        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!flag[i][j] && grid[i][j] == '1') {
                    island++;
                    flag[i][j] = true;
                    makeIsland(i, j, grid);

                }
            }
        }
        return island;

    }

    private static void makeIsland(int i, int j, char[][] grid) {
        int[] a = {1, 0, -1, 0};
        int[] b = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + a[k];
            int y = j + b[k];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                if (!flag[x][y] && grid[x][y] == '1') {
                    flag[x][y] = true;
                    makeIsland(x, y, grid);
                }
            }
        }
    }
}

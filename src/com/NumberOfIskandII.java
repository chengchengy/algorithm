package com;

import java.util.*;

/**
 * Created by chengcheng on 1/28/17.
 */
public class NumberOfIskandII {
    public static void main(String[] args) {
        int n = 2;
        int m = 8;
        int[][] position = {{7,0}};
        List<Integer> island = numIslands2(n,m,position);
        System.out.println(island);

    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        if (n <= 0 || m <= 0 || positions.length == 0) return list;

        int[] father = new int[n * m];
        Arrays.fill(father, -1); //all is empty;
        int count = 0;


        int[] a = {1, 0, -1, 0};
        int[] b = {0, 1, 0, -1};

        for (int[] p : positions) {
            int i = p[0];
            int j = p[1];
            count++;
            father[i * m + j] = i * m + j;

            int curIsland = father[i * m + j];


            for (int k = 0; k < 4; k++) {
                int x = i + a[k];
                int y = j + b[k];

                if (x >= 0 && y >= 0 && x < m && y < n && father[x * m + y] != -1) { //connected
                    int neighbour = findFather(x * m + y, father);
                    if (curIsland == neighbour) continue; //belongs to the same group
                    father[neighbour] = curIsland; //merge
                    count--;
                }
            }
            list.add(count);
        }

        return list;
    }

    private static int findFather(int id, int[] father) {
        while (father[id] != id) {
            id = father[id];
        }
        return id;
    }
}

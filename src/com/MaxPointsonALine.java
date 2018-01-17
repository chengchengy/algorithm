package com;

/**
 * Created by chengcheng on 9/16/16.
 */

import java.util.*;

public class MaxPointsonALine {

    public static void main(String[] args) {
        Point p1 = new Point(-4, -4);
        Point p2 = new Point(-8, -582);
        Point p3 = new Point(-3, 3);
        Point p4 = new Point(-9, -651);
        Point p5 = new Point(9, 591);
        Point[] points = {p1, p2, p3, p4, p5};
        int k = maxPoints(points);
        System.out.println(k);
    }


    public static int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        int max = 1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            Point p1 = points[i];
            int vertical = 0;
            int same = 0;
            int curMax = 0;

            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                Point p2 = points[j];
                int dx = p2.x - p1.x;
                int dy = p2.y - p1.y;
                if (dx == 0) {
                    if (dy == 0) {
                        same++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                int tmp = gcd(dx, dy);
                String key = dy / tmp + "/" + dx / tmp;
                map.put(key, map.getOrDefault(key, 0) + 1);
                curMax = Math.max(curMax, map.get(key));
            }
            curMax = Math.max(curMax, vertical);
            max = Math.max(max, curMax + same + 1);
        }
        return max;
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }

    }
}

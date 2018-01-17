package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengcheng on 9/1/17.
 */
public class NestedListWeightSumIIDepth {
    private int maxDepth;

    public static void main(String[] args) {

    }

    public int weightSum(List<NestedInteger> nestedList) {
        getDepth(nestedList, 1);
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * (maxDepth - depth + 1);
            } else {
                sum += helper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }

    private void getDepth(List<NestedInteger> list, int cur) {
        maxDepth = Math.max(maxDepth, cur);
        for (NestedInteger ni : list) {
            if (!ni.isInteger()) {
                getDepth(ni.getList(), cur + 1);
            }
        }
    }
}


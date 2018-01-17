package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengcheng on 9/1/17.
 */
public class NestedListWeightSumII {
    public static void main(String[] args) {

    }

    public int weightSum(List<NestedInteger> nestedList) {
        int unweight = 0;
        int weight = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    unweight += ni.getInteger();
                } else {
                    nextLevel.addAll(ni.getList());
                }
            }
            weight += unweight;
            nestedList = nextLevel;
        }
        return weight;
    }
}


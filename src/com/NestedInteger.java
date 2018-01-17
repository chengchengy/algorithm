package com;

import java.util.List;

/**
 * Created by chengcheng on 9/1/17.
 */
public class NestedInteger {
    Integer value;
    private List<NestedInteger> list;
    public NestedInteger() {

    }

    public NestedInteger(int value) {
        this.value = value;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }
    public void setInteger(int value) {
        this.value = value;
    }

    public void add(NestedInteger ni) {
        list.add(ni);
    }

    public List<NestedInteger> getList() {
        return list;
    }
}

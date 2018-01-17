package com;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengcheng on 9/1/17.
 */
public class InsertInterval {

    public static void main(String[] args) {


    }

    public List<Interval> insert(List<Interval> intervals, Interval newOne) {
        List<Interval> list = new ArrayList<>();
        int newStart = newOne.start;
        int newEnd = newOne.end;
        int lo = 0;
        int hi = intervals.size() - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (intervals.get(mid).start == newStart) {
                lo = mid;
                break;
            } else if (intervals.get(mid).start > newStart) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int startPos = lo;
        hi = intervals.size() - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (intervals.get(mid).start == newEnd) {
                lo = mid;
                break;
            } else if (intervals.get(mid).start > newEnd) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        int endPos = lo;

        int mergeStart;
        int mergeEnd;
        if (startPos == 0 || intervals.get(startPos - 1).end < startPos) {
            mergeStart = newStart;
        } else {
            mergeStart = intervals.get(startPos - 1).start;
            startPos--;
        }

        if (endPos < intervals.size() && intervals.get(endPos).start == newEnd) {
            mergeEnd = intervals.get(endPos).end;
            endPos++;
        } else if (endPos == 0 || intervals.get(endPos - 1).end > newEnd) {
            mergeEnd = newEnd;
        } else {
            mergeEnd = intervals.get(endPos - 1).end;
        }

        for (int i = 0; i < startPos; i++) {
            list.add(intervals.get(i));
        }

        list.add(new Interval(mergeStart, mergeEnd));
        for (int i = endPos; i < intervals.size(); i++) {
            list.add(intervals.get(i));
        }
        return list;
    }

    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}




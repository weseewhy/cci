/*
Sorted Search, No Size: 
You are given an array-like data structure Listy which lacks a size method. 
It does, however, have an elementAt (i) method that returns the element at index i in 0(1) time. 
If i is beyond the bounds of the data structure, it returns - 1. 
(For this reason, the data structure only supports positive integers.) 
Given a Listy which contains sorted, positive integers, find the index at which an element x occurs. 
If x occurs multiple times, you may return any index.
*/

import java.util.ArrayList;

class Solution {
    int searchSortedList(Listy listy, int target) {
        int end = 1;
        while (listy.get(end) != -1 && listy.get(end) < target) {
            end *= 2;
        }

        // No need to start form 0. We already checked before incrementing end
        int start = end / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = listy.get(mid);
            if (val == target) {
                return mid;
            } else if (val == -1 || val > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

class Listy extends ArrayList<Integer> {
    @Override
    public int size() {
        throw new UnsupportedOperationException("Size not supported");
    }

    @Override
    public Integer get(int index) {
        return index >= super.size() ? -1 : super.get(index);
    }
}

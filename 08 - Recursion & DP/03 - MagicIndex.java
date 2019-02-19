/*
Magic Index:
A magic index in an array A[1. .. n-1] is defined to be an index such that A[i] = i.
Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

FOLLOW UP: What if the values are not distinct?
*/

class Solution {
    public int magicIndex_distinct(int[] nums) {
        return magicIndex_distinct(nums, 0, nums.length - 1);
    }

    private int magicIndex_distinct(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == mid) {
            return mid;
        } else if (nums[mid] > mid) {
            return magicIndex_distinct(nums, start, mid - 1);
        } else {
            return magicIndex_distinct(nums, mid + 1, start);
        }
    }

    public int magicIndex_duplicates(int[] nums) {
        return magicIndex_duplicates(nums, 0, nums.length - 1);
    }

    private int magicIndex_duplicates(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == mid) {
            return mid;
        }

        // If magic index is not at mid, then it can be on either side
        // But no need to search of full subarrays
        int magicLeft = magicIndex_duplicates(nums, start, Math.min(mid - 1, nums[mid]));
        if (magicLeft != -1) {
            return magicLeft;
        }

        return magicIndex_duplicates(nums, Math.max(mid + 1, nums[mid]), end);
    }
}

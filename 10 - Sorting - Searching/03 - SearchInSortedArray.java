/*
Search in Rotated Array:
Given a sorted array of n integers that has been rotated an unknown number of times,
write code to find an element in the array. You may assume that the array was originally sorted in increasing order.

EXAMPLE
Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
Output: 8 (the index of 5 in the array)
*/

class Solution {

    int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    private int search(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[start] < arr[mid]) {
            if (arr[start] <= target && target <= arr[mid]) {
                return binarySearch(arr, start, mid - 1, target);
            } else {
                return search(arr, mid + 1, end, target);
            }
        } else if (arr[start] > arr[mid]) {
            if (arr[mid + 1] <= target && target <= arr[end]) {
                return binarySearch(arr, mid + 1, end, target);
            } else {
                return search(arr, start, mid - 1, target);
            }
        } else { // handles duplicates. One half has all duplicates
            if (arr[mid] != arr[end]) { // right half is different
                return search(arr, mid + 1, end, target);
            } else { // search both halves
                int index = search(arr, start, mid - 1, target);
                if (index == -1) {
                    index = search(arr, mid + 1, end, target);
                }
                return index;
            }
        }
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[start] == target ? start : -1;
    }
}

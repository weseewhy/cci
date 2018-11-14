/*
Peaks and Valleys:
In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers
and a "valley" is an element which is less than or equal to the adjacent integers.
For example, in the array {S, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {S, 2} are valleys.
Given an array of integers, sort the array into an alternating sequence of peaks and valleys.

Example:
Input: {5, 3, 1,2, 3}
Output: {5, 1, 3, 2, 3}
*/

class Solution {
    void alternatePeaksAndValleys(int[] arr) {
        if (arr.length < 3) {
            return;
        }

        for (int i = 1; i < arr.length; i = i + 2) {
            if (arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }

            if (i + 1 < arr.length && arr[i] < arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length && i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

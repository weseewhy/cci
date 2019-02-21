/*
Paint Fill: 
Implement the "paint fill" function that one might see on many image editing programs. 
That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color, 
fill in the surrounding area until the color changes from the original color.
*/

class Solution {

    public void fillColor(int[][] arr, int row, int col, int newVal) {
        if (isValid(arr, row, col)) {
            int curVal = arr[row][col];
            if (curVal != newVal) {
                fillColor(arr, row, col, curVal, newVal);
            }
        }
    }

    private void fillColor(int[][] arr, int row, int col, int curVal, int newVal) {
        if (isValid(arr, row, col) && arr[row][col] == curVal) {
            arr[row][col] = newVal;
            fillColor(arr, row, col - 1, curVal, newVal);
            fillColor(arr, row, col + 1, curVal, newVal);
            fillColor(arr, row - 1, col, curVal, newVal);
            fillColor(arr, row + 1, col, curVal, newVal);
        }
    }

    private boolean isValid(int[][] arr, int row, int col) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length;
    }
}

/*
Rotate Matrix:
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees.
Can you do this in place?
*/

class Solution {
    public void rotateMatrix(int[][] m) {
        for (int i = 0; i <= ((m.length + 1) / 2) - 1; i++) {
            rotateLayer(m, i);
        }
    }

    private void rotateLayer(int[][] m, int level) {
        int min = level;
        int max = m.length - level - 1;

        for (int i = 0; i <= max - min - 1; i++) {
            int temp = m[min][min + i];
            m[min][min + i] = m[max - i][min];
            m[max - i][min] = m[max][max - i];
            m[max][max - i] = m[min + i][max];
            m[min + i][max] = temp;
        }
    }
}

/*
Zero Matrix:
Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
Can you do it without extra space?
*/

class Solution {

    // O(w+h) space
    void setZeroes(int[][] m) {
        boolean[] rows = new boolean[m.length];
        boolean[] cols = new boolean[m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (rows[i] || cols[j]) {
                    m[i][j] = 0;
                }
            }
        }
    }

    // Constant extra space. Idea is to use 1st row and 1st column to save above info
    void setZeroes2(int[][] m) {
        boolean row1Has0 = false;
        boolean col1Has0 = false;

        for (int i = 0; i < m[0].length; i++) {
            if (m[0][i] == 0) {
                row1Has0 = true;
                break;
            }
        }

        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == 0) {
                col1Has0 = true;
                break;
            }
        }

        // Check for 0s in rest of matrix
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }

        // Nullify reset of matrix
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][0] == 0 || m[0][j] == 0) {
                    m[i][j] = 0;
                }
            }
        }

        if (row1Has0) {
            for (int i = 0; i < m[0].length; i++) {
                m[0][i] = 0;
            }
        }

        if (col1Has0) {
            for (int i = 0; i < m.length; i++) {
                m[i][0] = 0;
            }
        }
    }
}

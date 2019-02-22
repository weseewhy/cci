/*
Eight Queens: 
Write an algorithm to print all ways of arranging n queens on an nxn chess board 
so that none of them share the same row, column, or diagonal. 
In this case, "diagonal" means all diagonals, not just the two that bisect the board.
*/

import java.util.Arrays;

class Solution {
    boolean placeQueens(int n) {
        int[][] board = new int[n][n];
        boolean success = placeQueens(board, 0);

        if (success) {
            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }
        }

        return success;
    }

    private boolean placeQueens(int[][] board, int row) {
        if (row >= board.length) {
            return true;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValid(board, row, col)) {
                // Check if solution exists after placing queen at current column
                board[row][col] = 1;
                boolean success = placeQueens(board, row + 1);

                if (success) {
                    return true;
                } else {
                    // Placing queen at column 'col' didn't yield any possible solution
                    // backtrack and try next column
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    private boolean isValid(int[][] board, int row, int col) {
        for (int dist = 1; dist <= row; dist++) {
            // in all previous rows, check if queen present in current column
            // or diagonal from left or right
            if (board[row - dist][col] == 1) {
                return false;
            } else if (col - dist >= 0 && board[row - dist][col - dist] == 1) {
                return false;
            } else if (col + dist < board[0].length && board[row - dist][col + dist] == 1) {
                return false;
            }
        }

        return true;
    }
}

// Another possible way to denote the board state is by an array
// Where index of array will represent row
// and value at each index will represent the col in which queen is placed

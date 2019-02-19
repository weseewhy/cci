/*
Robot in a Grid: 
Imagine a robot sitting on the upper left corner of grid with r rows and c columns. 
The robot can only move in two directions, right and down, 
but certain cells are "off limits" such that the robot cannot step on them. 

Design an algorithm to find a path for the robot from the top left to the bottom right.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Point> getPath(int[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }

        List<Point> path = new ArrayList<>();
        boolean pathFound = traverse(maze, 0, 0, path);
        return pathFound ? path : null;
    }

    private boolean traverse(int[][] maze, int row, int col, List<Point> path) {
        if (isAtDestination(maze, row, col)) {
            return true;
        }

        path.add(new Point(row, col));
        boolean success = false;

        if (canTraverse(maze, row, col + 1)) {
            success = traverse(maze, row, col + 1, path);
        }

        if (!success && canTraverse(maze, row + 1, col)) {
            success = traverse(maze, row + 1, col, path);
        }

        if (!success) {
            path.remove(path.size() - 1);
            maze[row][col] = -1;
        }

        return success;
    }

    private boolean isValid(int[][] maze, int row, int col) {
        return row < maze.length && col < maze[0].length;
    }

    private boolean canTraverse(int[][] maze, int row, int col) {
        return isValid(maze, row, col) && maze[row][col] == 1;
    }

    private boolean isAtDestination(int[][] maze, int row, int col) {
        return row == maze.length - 1 && col == maze[0].length - 1;
    }
}

class Point {
    int row;
    int col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", this.row, this.col);
    }
}

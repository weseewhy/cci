/*
Towers of Hanoi: 
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes 
which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size 
from top to bottom (Le., each disk sits on top of an even larger one). 

You have the following constraints:
  (1) Only one disk can be moved at a time.
  (2) A disk is slid off the top of one tower onto another tower.
  (3) A disk cannot be placed on top of a smaller disk.

Write a program to move the disks from the first tower to the last using Stacks.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public void moveDisks(int numOfDisks) {
        List<Tower> towers = initializeTowers(numOfDisks);
        towers.forEach(System.out::println);
        moveDisks(towers, 0, 2, numOfDisks);
        towers.forEach(System.out::println);
    }

    private void moveDisks(List<Tower> towers, int src, int dest, int cnt) {
        if (cnt <= 0) {
            return;
        }

        int other = 3 - src - dest;
        moveDisks(towers, src, other, cnt - 1);
        towers.get(dest).push(towers.get(src).pop());
        moveDisks(towers, other, dest, cnt - 1);
    }

    private List<Tower> initializeTowers(int numOfDisks) {
        List<Tower> towers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            towers.add(new Tower());
        }
        for (int i = numOfDisks; i >= 1; i--) {
            towers.get(0).push(i);
        }

        return towers;
    }
}

class Tower extends Stack<Integer> {
    @Override
    public Integer push(Integer item) {
        if (!isEmpty() && item > peek()) {
            throw new RuntimeException(
                    String.format("Given number(%d) is greater than top(%d)", item, peek()));
        }
        return super.push(item);
    }
}

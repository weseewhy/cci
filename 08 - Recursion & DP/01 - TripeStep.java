/*
Triple Step: 
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up the stairs.
*/

class Solution {
    public int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        }

        int fn1 = 1;
        int fn2 = 1;
        int fn3 = 0;
        int fn = 0;

        for (int i = 2; i <= n; i++) {
            fn = fn1 + fn2 + fn3;
            fn3 = fn2;
            fn2 = fn1;
            fn1 = fn;
        }

        return fn;
    }
}

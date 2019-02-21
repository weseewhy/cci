/*
Coins:
Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
pennies (1 cent), write code to calculate the number of ways of representing n cents.
*/

class Solution {

    // f(n, i) --> number of ways to reach total n using first i coins
    // Now (i+1)th coin has two options -- include/exclude
    // so, f(n, i) =   f(n - c[i], i)   --> when the coin is included. reduce sum by value of coin
    //               + f(n, i-1)        --> when the current coin is not included
    public int numberOfWaysForCoinChange(int[] coins, int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int coinVal : coins) {
            for (int j = 0; j <= n; j++) {
                if (j >= coinVal) {
                    f[j] += f[j - coinVal];
                }
            }
        }

        return f[n];
    }
}

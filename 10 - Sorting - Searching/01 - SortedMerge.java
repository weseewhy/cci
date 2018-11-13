/*
Sorted Merge: 
You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. 
Write a method to merge B into A in sorted order.
*/

import java.util.Arrays;

class Solution {
    void merge(int[] big, int sizeB, int[] small) {
        if (sizeB + small.length > big.length) {
            throw new RuntimeException("No enough space");
        }

        int cur = sizeB + small.length - 1;
        int bigEnd = sizeB - 1;
        int smallEnd = small.length - 1;

        while (smallEnd >= 0 && bigEnd >= 0) {
            System.out.println(Arrays.toString(big));
            if (big[bigEnd] > small[smallEnd]) {
                big[cur] = big[bigEnd];
                bigEnd--;
            } else {
                big[cur] = small[smallEnd];
                smallEnd--;
            }

            cur--;
        }

        while (smallEnd >= 0) {
            big[cur] = small[smallEnd];
            cur--;
            smallEnd--;
        }
    }
}

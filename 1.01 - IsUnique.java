/*
Is Unique:
Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
*/

class Solution {
    public boolean isUnique(String s) {
        int bits = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int flag = 1 << (c - 'a');
            if ((bits & flag) > 0) {
                return false;
            }

            bits = bits | flag;
        }

        return true;
    }
}
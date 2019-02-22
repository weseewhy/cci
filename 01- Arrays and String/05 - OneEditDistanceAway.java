/*
One Away:
There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit (or zero edits) away.

Example:
pale, ple -> true 
pales, pale -> true 
pale, bale -> true 
pale, bae -> false
*/

class Solution {
    public boolean isOneAway(String s, String t) {
        int diff = s.length() - t.length();
        if (Math.abs(diff) > 1) {
            return false;
        }

        if (diff == 0) {
            return isReplaceAway(s, t);
        } else {
            return diff == 1 ? isInsertAway(t, s) : isInsertAway(s, t);
        }
    }

    private boolean isReplaceAway(String s, String t) {
        boolean replaced = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (replaced) {
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }

    private boolean isInsertAway(String small, String big) {
        int si = 0;
        int bi = 0;
        while (si < small.length() && bi < big.length()) {
            if (small.charAt(si) != big.charAt(bi)) {
                if (si != bi) {
                    return false;
                }
            } else {
                si++;
            }
            bi++;
        }
        return true;
    }
}

/*
Palindrome Permutation: 
Given a string, write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards.
A permutation is a rearrangement of letters. 
The palindrome does not need to be limited to just dictionary words.

EXAMPLE
Input: Tact Coa
Output: True (permutations:"taco cat'; "atco cta '; etc.)
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPalindromePermutation(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
            }
        }

        boolean isOdd = false;
        for (int val : cnt.values()) {
            if (val % 2 == 1) {
                if (isOdd) {
                    return false;
                } else {
                    isOdd = true;
                }
            }
        }

        return true;
    }
}

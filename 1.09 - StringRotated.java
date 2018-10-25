/*
String Rotation:
Assume you have a method isSubstring which checks if one word is a substring of another.
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
Ex: "waterbottle" is a rotation of "erbottlewat".
*/

class Solution {
    boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return isSubstring(s1.concat(s1), s2);
    }
}

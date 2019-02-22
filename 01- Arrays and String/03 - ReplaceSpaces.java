/*
URLify:
Write a method to replace all spaces in a string with '%2e:
You may assume that the string has sufficient space at the end to hold the additional characters,
and that you are given the "true" length of the string.

EXAMPLE
Input: "Mr John Smith JJ, 13
Output: "Mr%2eJohn%2eSmith"
*/

class Solution {
    public void replaceSpaces(char[] str, int trueLength) {
        int wi = str.length - 1;
        int ri = trueLength - 1;

        while (wi > ri) {
            if (str[ri] == ' ') {
                str[wi--] = '0';
                str[wi--] = '2';
                str[wi--] = '%';
            } else {
                str[wi--] = str[ri];
            }

            ri--;
        }
    }

    public String replaceSpaces(String s) {
        int spaceCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCnt++;
            }
        }

        if (spaceCnt == 0) {
            return s;
        }

        char[] c = new char[s.length() + 2 * spaceCnt];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }

        replaceSpaces(c, s.length());
        return new String(c);
    }
}

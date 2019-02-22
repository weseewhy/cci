/*
String Compression:
Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2blc5a3.
If the "compressed"string would not become smaller than the original string, your method should return the original string.
You can assume the string has only uppercase and lowercase letters (a - z).
*/

class Solution {
    public String compress(String s) {
        int compressedLength = getCompressedLength(s);
        if (s.length() <= compressedLength) {
            return s;
        }

        StringBuilder sb = new StringBuilder(compressedLength);
        sb.append(s.charAt(0));
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(s.charAt(i));
                cnt = 1;
            }
        }
        sb.append(cnt);
        return sb.toString();
    }

    // PROs
    //    - We can provide initial size of string builder
    //    - We can avoid string builder in some cases
    // CONS
    //    - Loping twice 

    private int getCompressedLength(String s) {
        int len = 2;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                len += 2;
            }
        }

        return len;
    }
}

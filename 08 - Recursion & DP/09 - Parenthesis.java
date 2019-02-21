/*
Parens:
Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n pairs of parentheses.

Example:
Input: 3
Output: ((())), (()()), (())(), ()(()), ()()()
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int cnt) {
        List<String> out = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(sb, cnt, cnt, out);
        return out;
    }

    private void generateParenthesis(StringBuilder sb, int leftBrackets, int rightBrackets, List<String> out) {
        if (leftBrackets < 0 || rightBrackets < leftBrackets) {
            return; // invalid state
        }

        if (rightBrackets == 0) {
            out.add(sb.toString());
        } else {
            sb.append("(");
            generateParenthesis(sb, leftBrackets - 1, rightBrackets, out);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            generateParenthesis(sb, leftBrackets, rightBrackets - 1, out);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

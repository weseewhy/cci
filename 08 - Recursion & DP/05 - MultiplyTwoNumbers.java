/*
Recursive Multiply: 
Write a recursive function to multiply two integers without using the * operator (or / operator). 
You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
*/

class Solution {
    public int multiple(int x, int y) {
        boolean isNegative = ((x < 0 && y >= 0) || (x >= 0 && y < 0));
        x = Math.abs(x);
        y = Math.abs(y);
        int num = Math.max(x, y);
        int times = Math.min(x, y);

        int result = multiply(num, times);
        if (isNegative) {
            result = 0 - result;
        }

        return result;
    }

    private int multiply(int num, int times) {
        if (times == 0) {
            return 0;
        } else if (times == 1) {
            return num;
        }

        int result = multiple(num, times >> 1);
        result += result;
        if (times % 2 == 1) {
            result += num;
        }

        return result;
    }
}

/*
Sparse Search:
Given a sorted array of strings that is interspersed with empty strings,
write a method to find the location of a given string.

Example:
Input: ball, {"at", "", "", "", "ball", "" , "", "car", "", "", "dad", "", ""}
Output: 4
*/

class Solution {
    int sparseSearch(String[] strings, String target) {
        if (target.isEmpty()) {
            return -1;
        }

        int start = 0;
        int end = strings.length - 1;

        // First non empty string
        while (start <= end && strings[start].isEmpty()) {
            start++;
        }

        // Last non empty string
        while (start <= end && strings[end].isEmpty()) {
            end--;
        }

        // All empty strings
        if (start >= strings.length || strings[start].isEmpty()) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If mid is empty, find non empty string to the left
            if (strings[mid].isEmpty()) {
                while (start < mid && strings[mid].isEmpty()) {
                    mid--;
                }
            }

            // If no non-empty string in left, find it to the right
            if (strings[mid].isEmpty()) {
                while (mid < end && strings[mid].isEmpty()) {
                    mid++;
                }
            }

            // Can't find any non-empty string
            if (strings[mid].isEmpty()) {
                return -1;
            }

            // Compare with non-empty mid to the target and recurse on appropriate half 
            String cur = strings[mid];
            if (cur.isEmpty()) {
                return -1;
            } else if (cur.equals(target)) {
                return mid;
            } else if (strings[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

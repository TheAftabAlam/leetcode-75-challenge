Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] charArray = s.toCharArray();
        // Arrays.sort(charArray);
        // String newStr1 = new String(charArray);

        // char[] charArray2 = t.toCharArray();
        // Arrays.sort(charArray2);
        // String newStr2 = new String(charArray2);

        // return newStr1.equals(newStr2);

        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // only lowercase letters

        // Count characters in s and subtract from t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;

    }
}

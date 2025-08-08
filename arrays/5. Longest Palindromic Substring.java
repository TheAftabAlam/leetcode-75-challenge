5. Longest Palindromic Substring

  Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.


  class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String res = "";
    	for(int i=0; i<s.length(); i++){
    		for(int j=i; j<=s.length(); j++){
    			String subStr = s.substring(i,j);
                // System.out.println(subStr);
    			int length =  palindromLength(subStr);
    			if(maxLength < length){
    				maxLength = length;
    				res = subStr;
    			}
    		}
    	}
        return res;
    }

    public int palindromLength(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
        	if(s.charAt(left) != s.charAt(right)){
        		return 0;
        	}
        	left++;
        	right--;
        }
        return s.length();
    }
}

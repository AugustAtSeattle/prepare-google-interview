package LongestPalindromicSubstring;

public class Solution {
    private int begin, maxLength;
    public String longestPalindrome(String s) {
        if(s == null) return "";
        if(s.length() < 2) return s;
        
        for(int i = 0; i < s.length(); i++){
            extendPalindrome(s,i, i);
            extendPalindrome(s,i, i + 1);
        }
        
        return s.substring(begin, begin + maxLength);
    }
    
    private void extendPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if(right - left - 1 > maxLength){
            maxLength = right - left - 1;
            begin = left + 1;
        }
    }
}

// Summary
// 1. s.substring(begin, begin + subLength)
// 2. s.charAt(index)

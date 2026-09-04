class Solution {
    
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1, start = 0;
        for (int i = 0; i < n; i++) {
            int oddLen = expandOutwardPalindromeLength(s, i, i);
            int evenLen = expandOutwardPalindromeLength(s, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (maxLen < curMaxLen) {
                maxLen = curMaxLen;
                start = i - (curMaxLen - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);

    }

    private static int expandOutwardPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

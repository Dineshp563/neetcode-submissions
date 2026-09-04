class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1, start = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        int curLen = j - i + 1;
                        if (curLen >= maxLen) {
                            maxLen = curLen;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);

    }
}

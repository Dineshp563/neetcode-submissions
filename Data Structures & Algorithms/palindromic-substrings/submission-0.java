class Solution {
   

    public int countSubstrings(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int oddPalindromeCount = longestPalindromeOutwards(s, i, i);
            int evenPalindromeCount = longestPalindromeOutwards(s, i, i + 1);
            max += oddPalindromeCount;
            max += evenPalindromeCount;
        }
        return max;
    }

    private int longestPalindromeOutwards(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}

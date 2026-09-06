class Solution {
    
    public int numDecodings(String s) {
        
        // Base case: leading zero means 0 ways to decode
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();

        int prev1 = 1, prev2 = 1;
        for (int i = 1; i < n; i++) {
            int curValue = 0;
            if ('0' != s.charAt(i)) {
                curValue += prev1;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (10 <= twoDigit && twoDigit <= 26) {
                curValue += prev2;
            }
            prev2 = prev1;
            prev1 = curValue;
        }
        return prev1;
    } 

}

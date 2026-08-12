class Solution {
    public String minWindow(String s, String t) {
        // Base case: if t is longer than s, it's impossible
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Map to store the frequency of characters we NEED from t
        int[] charMap = new int[128];
        for (char c : t.toCharArray()) {
            charMap[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0; // Tracks how many required characters we have matched
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0; // Tracks the start of our best window

        // Phase 1: Expand the window by moving 'right'
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If this character is needed (count in map is > 0), we found a match!
            if (charMap[rightChar] > 0) {
                count++;
            }
            
            // Decrease the requirement in our map (can go negative for chars we don't need)
            charMap[rightChar]--;
            right++;

            // Phase 2: Shrink the window by moving 'left'
            // We only enter this loop when our window is completely VALID
            while (count == t.length()) {
                
                // Record this window if it's the smallest we've seen so far
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                
                // Since we are moving left, we are putting a character back.
                // We add it back to our map requirements.
                charMap[leftChar]++;
                
                // If the requirement becomes > 0, it means we just threw away a required character!
                if (charMap[leftChar] > 0) {
                    count--; // Our window is no longer valid, which will break the while loop
                }
                
                left++;
            }
        }

        // If minLength was never updated, no valid window was found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
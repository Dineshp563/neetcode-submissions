class Solution {
    public int characterReplacement(String s, int k) {// Since it's only uppercase English letters, an array of size 26 is perfect
        int[] charCounts = new int[26]; 
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. Get the current character's index (0 to 25) and increment its count
            int currentCharIdx = s.charAt(right) - 'A';
            charCounts[currentCharIdx]++;
            
            // 2. What is the highest frequency of ANY character in our window right now?
            maxFreq = Math.max(maxFreq, charCounts[currentCharIdx]);

            // 3. The Math Check: (Window Length - Max Frequency)
            // If the characters we need to replace are more than 'k', our window is invalid.
            int windowLen = right - left + 1;
            if (windowLen - maxFreq > k) {
                // Shrink the window from the left
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }

            // 4. Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

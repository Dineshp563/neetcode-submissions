class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0; 
        int[] charCount = new int[129];
        for (int right = 0, left = 0; right < s.length(); right++) { 
            char currChar = s.charAt(right);
            charCount[currChar]++;
            while (charCount[currChar] > 1 && left<=right) {
                char leftChar = s.charAt(left++);
                charCount[leftChar]--; 
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

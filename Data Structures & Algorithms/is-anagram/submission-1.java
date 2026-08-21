class Solution {
    public boolean isAnagram(String s, String t) {
if (s.length() != t.length()) return false;
    
    int[] charCounts = new int[26];
    
    // First loop: Count characters in string 's'
    for (int i = 0; i < s.length(); i++) {
        charCounts[s.charAt(i) - 'a']++;
    }
    
    // Second loop: Reduce counts using string 't' and fail early
    for (int i = 0; i < t.length(); i++) {
        int index = t.charAt(i) - 'a';
        charCounts[index]--;
        
        // Early fail: If we ever dip below 0, it's not an anagram
        if (charCounts[index] < 0) {
            return false;
        }
    }
    return true;
    }
}

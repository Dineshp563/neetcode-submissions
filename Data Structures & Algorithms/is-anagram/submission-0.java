class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
    
    int[] charCounts = new int[26];
    
    // You can do this in two passes like you suggested, 
    // or even in a single pass since we know the lengths are equal!
    for (int i = 0; i < s.length(); i++) {
        charCounts[s.charAt(i) - 'a']++;
        charCounts[t.charAt(i) - 'a']--;
    }
    
    // Check if any count is non-zero (if we did a single pass)
    // Or if you do two passes, your < 0 check works perfectly.
    for (int count : charCounts) {
        if (count != 0) {
            return false;
        }
    }
    
    return true;
    }
}

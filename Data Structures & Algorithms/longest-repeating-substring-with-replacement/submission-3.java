class Solution {
    public int characterReplacement(String s, int k) {
       
        int[] charCounts = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rc=s.charAt(right);
            int rcf=++charCounts[rc-'A'];
            maxFreq=Math.max(maxFreq,rcf);
            if(right-left+1-maxFreq>k){
                char lc=s.charAt(left);
                charCounts[lc-'A']--;
                left++;
            }
            maxLength=Math.max(right-left+1, maxLength);
        }

        return maxLength;
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] chcount = new int[123];
        for (char c : t.toCharArray()) {
            chcount[c]++;
        }
        int startIndex = -1;
        int left = 0, count = 0;
        int minLength = s.length()+1;
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (chcount[rc]-- > 0) {
                count++;
            }
            if (count == t.length()) {
                while (count == t.length()) {
                    char lc = s.charAt(left);
                    if (++chcount[lc] > 0) {
                        count--;
                    }
                    left++;
                }
                int cl = right - left + 2;
                if (cl < minLength) {
                    minLength = cl;
                    startIndex = left - 1;
                }
            }

        }
        if (startIndex >= 0) {
            return s.substring(startIndex, startIndex+minLength);
        }
        return "";
    }
}

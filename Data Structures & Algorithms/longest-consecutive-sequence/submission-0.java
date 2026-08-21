class Solution {
    public int longestConsecutive(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            int localLen = 0, cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur)) {
                    cur++;
                    localLen++;
                }
            }
            maxLength = Math.max(maxLength, localLen);
        }
        return maxLength;
    }
}

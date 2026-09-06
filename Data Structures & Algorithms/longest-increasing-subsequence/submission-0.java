class Solution {
    
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        // Base case: every element is a subsequence of length 1
        Arrays.fill(dp, 1);
        int maxLength = 1;
        // i is the current element we are evaluating
        for (int i = 1; i < n; i++) {
            // j looks back at every element before i
            for (int j = 0; j < i; j++) {
                // If we find a strictly smaller number, we can extend its subsequence
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Keep track of the maximum sequence found so far
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}

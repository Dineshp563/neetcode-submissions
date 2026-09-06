class Solution {
    public int change(int amount, int[] coins) {
       
        int[] dp = new int[amount + 1];

        // Base case: 1 way to make amount 0
        dp[0] = 1;

        // OUTER LOOP: Iterate through coins first to ensure combinations, not permutations
        for (int coin : coins) {

            // INNER LOOP: Iterate through all amounts that can fit this coin
            for (int i = coin; i <= amount; i++) {

                // Add the number of ways we could make the leftover amount
                dp[i] = dp[i] + dp[i - coin];

            }
        }

        return dp[amount];
    }
}

class Solution {
   
    public int coinChange(int[] coins, int amount) {

        int amountMax = amount + 1;
        int[] dp = new int[amountMax];
        Arrays.fill(dp, amountMax);
        dp[0] = 0;
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (coin <= currentAmount) {
                    dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
                }
            }
        }
        return dp[amount] == amountMax ? -1 : dp[amount];
    }
}

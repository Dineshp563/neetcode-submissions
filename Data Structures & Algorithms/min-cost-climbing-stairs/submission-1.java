class Solution {
    
    public static int minCostClimbingStairs(int[] cost) {
        int prev1 = 0, prev2 = 0;

        for (int i = 2; i <= cost.length; i++) {
            int currentCost = Math.min(prev2 + cost[i - 1], prev1 + cost[i - 2]);
            prev1 = prev2;
            prev2 = currentCost;
        }
        return prev2;
    }
}

class Solution {
     public int maxProfit(int[] prices) {
        //= [10,1,5,6,7,1]
        int buy = 0, sell = 0;
        int maxProfit = 0, lowPrice = Integer.MAX_VALUE;
        for (; sell < prices.length; sell++) {
            int currentPrice = prices[sell];
            if (currentPrice < lowPrice) {
                lowPrice = currentPrice;
                buy = sell;
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
        }
        return maxProfit;
    }
}

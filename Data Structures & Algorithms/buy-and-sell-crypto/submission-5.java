class Solution {
    public int maxProfit(int[] prices) {
        int mp = 0;
        int sell = 1, buy = 0;
        while (sell < prices.length) {
            if (prices[sell] > prices[buy]) {
                int cp = prices[sell] - prices[buy];
                mp = cp > mp ? cp : mp;
            }
            else {
                buy = sell;
            }
            sell++;
        }
        return mp;
    }
}

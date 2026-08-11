class Solution {
        public int maxProfit(int[] prices) {
            int mp = 0;
            if( prices.length<2){
                return mp;
            }
        int sell = 1, buy = 0;
        while (buy < sell) {
            int cp = prices[sell] - prices[buy];
            if (cp > mp) {
                mp = cp;
            }
            if (prices[sell] < prices[buy]) {
                buy++;
                if (buy == sell && sell < prices.length - 1) {
                    sell++;
                }
            } else if (sell < prices.length - 1) {
                sell++;
            } else {
                buy++;
            }

        }
        return mp;
        }
}

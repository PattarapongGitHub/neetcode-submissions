class Solution {
    public int maxProfit(int[] prices) {
        int output = 0;
        int min_prices = prices[0];

        for (int i = 1; i < prices.length; i++) {
            min_prices = Math.min(min_prices, prices[i]);
            int profit = prices[i] - min_prices;

            if (profit > output) {
                output = profit;
            }
        }
        return output;
    }
}

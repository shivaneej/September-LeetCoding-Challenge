class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, i = 0;
        int maxProfit = 0;
        while(i < n) {
            int currentPrice = prices[i];
            int j = i + 1;
            while(j < n && prices[j] > currentPrice) {
                maxProfit = Math.max(maxProfit, prices[j] - currentPrice);
                j++;
            }
            i = j;
        }
        return maxProfit;
    }
}
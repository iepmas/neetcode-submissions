class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        int r = 0;
        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
                r = l + 1;
            }

        }
        return maxProfit;
    }
}

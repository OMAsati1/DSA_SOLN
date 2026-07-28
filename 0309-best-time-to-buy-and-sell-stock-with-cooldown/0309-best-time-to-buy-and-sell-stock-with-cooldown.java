class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][3];
        for(var a : dp) Arrays.fill(a,-1);
        return rec(prices, 0, 0);
    }

    int rec(int[] prices, int i, int state) {
        if (i == prices.length) return 0;
        if(dp[i][state]!=-1) return dp[i][state];
        if (state == 1) { // hold
            int sell = prices[i] + rec(prices, i + 1, 2);
            int skip = rec(prices, i + 1, 1);
            return dp[i][state] = Math.max(sell, skip);
        } else if (state == 2) { // coolDown
            return dp[i][state] = rec(prices, i + 1, 0);
        } else { // free
            int buy = -prices[i] + rec(prices, i + 1, 1);
            int skip = rec(prices, i + 1, 0);
            return dp[i][state] = Math.max(buy, skip);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
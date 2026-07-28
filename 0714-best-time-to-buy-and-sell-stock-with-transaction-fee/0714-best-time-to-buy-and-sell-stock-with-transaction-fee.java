class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // dp[n][*] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            // hold = true
            int sell = prices[i] - fee + dp[i + 1][0];
            int skip1 = dp[i + 1][1];
            dp[i][1] = Math.max(sell, skip1);

            // hold = false
            int buy = -prices[i] + dp[i + 1][1];
            int skip0 = dp[i + 1][0];
            dp[i][0] = Math.max(buy, skip0);
        }

        return dp[0][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
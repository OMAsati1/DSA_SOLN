class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        // base case: dp[n][0] = 0, dp[n][1] = 0 (already 0 by default in Java)

        for (int i = n - 1; i >= 0; i--) {
            // hold = 0 (nothing held)
            int buy = -prices[i] + dp[i + 1][1];
            int skip0 = dp[i + 1][0];
            dp[i][0] = Math.max(buy, skip0);

            // hold = 1 (holding stock)
            int sell = prices[i] + dp[i + 1][0];
            int skip1 = dp[i + 1][1];
            dp[i][1] = Math.max(sell, skip1);
        }

        return dp[0][0];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
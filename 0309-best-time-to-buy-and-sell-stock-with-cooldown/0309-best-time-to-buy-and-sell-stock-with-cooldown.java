class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][3]; // dp[n][*] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            // state 1: hold
            int sell = prices[i] + dp[i + 1][2];
            int skip1 = dp[i + 1][1];
            dp[i][1] = Math.max(sell, skip1);

            // state 2: coolDown
            dp[i][2] = dp[i + 1][0];

            // state 0: free
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
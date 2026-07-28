class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int next0 = 0, next1 = 0, next2 = 0; // dp[i+1][0], dp[i+1][1], dp[i+1][2]

        for (int i = n - 1; i >= 0; i--) {
            int sell = prices[i] + next2;
            int skip1 = next1;
            int cur1 = Math.max(sell, skip1);

            int cur2 = next0;

            int buy = -prices[i] + next1;
            int skip0 = next0;
            int cur0 = Math.max(buy, skip0);

            next0 = cur0;
            next1 = cur1;
            next2 = cur2;
        }

        return next0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
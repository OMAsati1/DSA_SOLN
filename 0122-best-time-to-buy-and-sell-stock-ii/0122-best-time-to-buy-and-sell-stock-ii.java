class Solution {
    int rec(int[] prices, int i, int hold, int[][] memo) {
        if (i == prices.length) return 0;

        if (memo[i][hold] != -1) return memo[i][hold];

        int result;
        if (hold == 0) {
            // buy
            int buy = -prices[i] + rec(prices, i + 1, 1, memo);
            // skip
            int skip = rec(prices, i + 1, 0, memo);
            result = Math.max(buy, skip);
        } else {
            // sell
            int sell = prices[i] + rec(prices, i + 1, 0, memo);
            // skip
            int skip = rec(prices, i + 1, 1, memo);
            result = Math.max(sell, skip);
        }

        memo[i][hold] = result;
        return result;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] row : memo) 
            Arrays.fill(row, -1);
        
        return rec(prices, 0, 0, memo);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
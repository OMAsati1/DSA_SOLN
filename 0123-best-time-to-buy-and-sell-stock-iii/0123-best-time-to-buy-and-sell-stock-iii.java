class Solution {
    int rec(int[] prices, int i, int hold, int[][][] memo, int cap) {
        if (i == prices.length) return 0;
        if(cap==0) return 0;

        if (memo[i][hold][cap] != -1) return memo[i][hold][cap];

        int result;
        if (hold == 0) {
            // buy
            int buy = -prices[i] + rec(prices, i + 1, 1, memo,cap);
            // skip
            int skip = rec(prices, i + 1, 0, memo,cap);
            result = Math.max(buy, skip);
        } else {
            // sell
            int sell = prices[i] + rec(prices, i + 1, 0, memo,cap-1);
            // skip
            int skip = rec(prices, i + 1, 1, memo,cap);
            result = Math.max(sell, skip);
        }

        memo[i][hold][cap] = result;
        return result;
    }

    int tab(int[] prices){
         int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        // base case: dp[n][0][0] = 0, dp[n][1][0] = 0 (already 0 by default in Java)

        for (int i = n - 1; i >= 0; i--) {
            for(int j=1;j<3;j++){
            // hold = 0 (nothing held)
            int buy = -prices[i] + dp[i + 1][1][j];
            int skip0 = dp[i + 1][0][j];
            dp[i][0][j] = Math.max(buy, skip0);

            // hold = 1 (holding stock)
            int sell = prices[i] + dp[i + 1][0][j-1];
            int skip1 = dp[i + 1][1][j];
            dp[i][1][j] = Math.max(sell, skip1);
        }
        }
        return dp[0][0][2];
    }

    public int maxProfit(int[] prices) {
        /*int n = prices.length;
        int[][][] memo = new int[n][2][3];
        for (int[][] mat : memo) 
            for(int[] row : mat)
            Arrays.fill(row, -1);
        
        return rec(prices, 0, 0, memo,2); */
        return tab(prices);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
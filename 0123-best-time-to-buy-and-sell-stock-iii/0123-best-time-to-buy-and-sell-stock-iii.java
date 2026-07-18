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

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] memo = new int[n][2][3];
        for (int[][] mat : memo) 
            for(int[] row : mat)
            Arrays.fill(row, -1);
        
        return rec(prices, 0, 0, memo,2);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
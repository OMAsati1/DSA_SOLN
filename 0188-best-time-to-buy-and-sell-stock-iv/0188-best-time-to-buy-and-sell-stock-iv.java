class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] next = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int cap = 1; cap <= k; cap++) {

                // hold = 0
                curr[0][cap] = Math.max(
                        -prices[i] + next[1][cap],
                        next[0][cap]);

                // hold = 1
                curr[1][cap] = Math.max(
                        prices[i] + next[0][cap - 1],
                        next[1][cap]);
            }

            // copy curr -> next
            for (int hold = 0; hold <= 1; hold++) {
                for (int cap = 0; cap <= k; cap++) {
                    next[hold][cap] = curr[hold][cap];
                }
            }
        }

        return next[0][k];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
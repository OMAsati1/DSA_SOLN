class Solution {

    int[][] grid;
    int limit, rows, cols;

    public int maxConsistentColumns(int[][] grid, int limit) {

        this.grid = grid;
        this.limit = limit;
        rows = grid.length;
        cols = grid[0].length;

        int[][] dp = new int[cols + 1][cols + 1];

        // Base:
        // dp[cols][*] = 0

        for (int curr = cols - 1; curr >= 0; curr--) {

            for (int prev = curr - 1; prev >= -1; prev--) {

                // Skip
                int ans = dp[curr + 1][prev + 1];

                // Keep
                if (prev == -1 || valid(prev, curr))
                    ans = Math.max(ans, 1 + dp[curr + 1][curr + 1]);

                dp[curr][prev + 1] = ans;
            }
        }

        return dp[0][0];
    }

    boolean valid(int prev, int curr) {

        for (int i = 0; i < rows; i++) {
            if (Math.abs(grid[i][curr] - grid[i][prev]) > limit)
                return false;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
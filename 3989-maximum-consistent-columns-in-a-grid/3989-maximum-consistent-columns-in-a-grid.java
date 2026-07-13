class Solution {

    int[][] grid;
    int limit, rows, cols;
    int[][] dp;

    public int maxConsistentColumns(int[][] grid, int limit) {

        this.grid = grid;
        this.limit = limit;
        rows = grid.length;
        cols = grid[0].length;

        dp = new int[cols + 1][cols + 1];

        for (int i = 0; i <= cols; i++)
            Arrays.fill(dp[i], -1);

        return solve(0, -1);
    }

    int solve(int curr, int prev) {

        if (curr == cols)
            return 0;

        if (dp[curr][prev + 1] != -1)
            return dp[curr][prev + 1];

        // Skip current column
        int ans = solve(curr + 1, prev);

        // Keep current column
        if (prev == -1 || valid(prev, curr))
            ans = Math.max(ans, 1 + solve(curr + 1, curr));

        return dp[curr][prev + 1] = ans;
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
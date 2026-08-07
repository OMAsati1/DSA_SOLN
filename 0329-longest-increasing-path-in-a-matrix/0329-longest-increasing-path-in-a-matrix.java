class Solution {

    int[][] dir = {
        {-1, 0},  // up
        {1, 0},   // down
        {0, -1},  // left
        {0, 1}    // right
    };

    int dfs(int i, int j, int[][] matrix, int[][] dp) {

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int maxPath = 1;

        for (int[] d : dir) {

            int newI = i + d[0];
            int newJ = j + d[1];

            if (newI >= 0 && newI < m &&
                newJ >= 0 && newJ < n &&
                matrix[newI][newJ] > matrix[i][j]) {

                maxPath = Math.max(
                    maxPath,
                    1 + dfs(newI, newJ, matrix, dp)
                );
            }
        }

        // Store before returning
        return dp[i][j] = maxPath;
    }

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        // -1 means not calculated
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                ans = Math.max(
                    ans,
                    dfs(i, j, matrix, dp)
                );
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
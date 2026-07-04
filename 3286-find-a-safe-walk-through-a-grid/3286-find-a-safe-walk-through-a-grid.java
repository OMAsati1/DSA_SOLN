class Solution {
    int m, n;
    int[][] minCost;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        minCost = new int[m][n];
        for (int[] row : minCost) Arrays.fill(row, Integer.MAX_VALUE);

        dfs(grid, 0, 0, grid.get(0).get(0));

        int hazards = minCost[m - 1][n - 1];
        return health - hazards >= 1;
    }

    void dfs(List<List<Integer>> grid, int i, int j, int cost) {
        if (cost >= minCost[i][j]) return;
        minCost[i][j] = cost;

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                int ncost = cost + grid.get(ni).get(nj);
                dfs(grid, ni, nj, ncost);
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
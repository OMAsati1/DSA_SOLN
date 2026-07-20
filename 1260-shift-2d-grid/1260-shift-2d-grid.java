class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int total = m * n;

    k %= total;

    int[][] temp = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {

            int idx = i * n + j;          // Current 1D index
            int newIdx = (idx + k) % total; // Index after k shifts

            int newRow = newIdx / n;
            int newCol = newIdx % n;

            temp[newRow][newCol] = grid[i][j];
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    for (int[] row : temp) {
        List<Integer> curr = new ArrayList<>();
        for (int val : row)
            curr.add(val);
        ans.add(curr);
    }

    return ans;
}
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
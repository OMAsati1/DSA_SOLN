class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        for(int l=0;l<k;l++){
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    temp[i][j] = grid[m - 1][n - 1];
                else if (j == 0)
                    temp[i][j] = grid[i - 1][n - 1];
                else
                    temp[i][j] = grid[i][j - 1];
            }
        }
        grid=temp;
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] row : grid) {
            List<Integer> curr = new ArrayList<>();
            for (int val : row) {
                curr.add(val);
            }
            ans.add(curr);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
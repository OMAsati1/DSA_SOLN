class Solution {

    int[][] dp;

    public int perfectSum(int[] nums, int target) {
        int n = nums.length;

        dp = new int[n][target + 1];

        // Initialize with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, target, nums);
    }

    private int solve(int idx, int target, int[] nums) {

        // Base case
        if (idx == nums.length) {
            return (target == 0) ? 1 : 0;
        }

        // Memoization
        if (dp[idx][target] != -1)
            return dp[idx][target];

        // Don't take
        int notTake = solve(idx + 1, target, nums);

        // Take
        int take = 0;
        if (nums[idx] <= target) {
            take = solve(idx + 1, target - nums[idx], nums);
        }

        return dp[idx][target] = take + notTake;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
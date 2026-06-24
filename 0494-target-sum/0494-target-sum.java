class Solution {
    int[][] dp; 

    int rec(int[] nums, int i, int sum, int target) {
        if (i == nums.length)
            return sum == target ? 1 : 0;

        int plus = rec(nums, i + 1, sum + nums[i], target);
        int minus = rec(nums, i + 1, sum - nums[i], target);

        return plus + minus;
    }

    int memo(int[] nums, int i, int sum, int target) {
        if (i == nums.length)
            return sum == target ? 1 : 0;

        if(dp[i][sum]!=-1) return dp[i][sum];

        int plus = rec(nums, i + 1, sum + nums[i], target);
        int minus = rec(nums, i + 1, sum - nums[i], target);

        return dp[i][sum] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        // return rec(nums, 0, 0, target);
        int n = nums.length;
        dp = new int[n][2001];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return memo(nums,0,0,target);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
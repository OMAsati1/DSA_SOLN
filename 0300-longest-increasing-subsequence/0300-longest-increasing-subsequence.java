class Solution {
    int [][] dp ;
    int rec(int idx, int prev, int[] nums) {
        if (idx == nums.length)
            return 0;

            if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int skip = rec(idx + 1, prev, nums);
        int take = Integer.MIN_VALUE;
        if (prev == -1 || nums[idx] > nums[prev])
            take = 1 + rec(idx + 1, idx, nums);
        return dp[idx][prev+1] = Math.max(skip, take);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1]; 
        for(int[] a : dp) Arrays.fill(a,-1);
        return rec(0, -1, nums);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
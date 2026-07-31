class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1]; // dp[idx+1][...], all 0 initially (base case idx==n)
        int[] curr = new int[n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx - 1; prev >= -1; prev--) {
                int skip = next[prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || nums[idx] > nums[prev])
                    take = 1 + next[idx + 1];
                curr[prev + 1] = Math.max(skip, take);
            }
            next = curr;
        }
        return next[0]; // idx=0, prev=-1 → prev+1=0
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
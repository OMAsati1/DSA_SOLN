class Solution {
    int[][] dp;

    boolean rec(int[] nums, int sum, int i){
        if (sum == 0) return true;
        if (i == 0) return nums[0]==sum;

        if (dp[i][sum] != -1) return dp[i][sum] == 1;

         boolean pick = false;
        if (sum >= nums[i]) {
            pick = rec(nums, sum - nums[i], i - 1);
        }
        boolean unpick = rec(nums, sum, i - 1);

        dp[i][sum] = (pick || unpick) ? 1 : 0;
        return pick || unpick;
    }



    public boolean canPartition(int[] nums) {
        int n = nums.length;
         int sum = 0;
         for(int a : nums) sum+=a;
        if((sum&1)==1) return false;
        sum/=2;
        dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return rec(nums, sum, n-1); 
 
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
class Solution {
    int[][] dp;
     private int solve(int[] nums,int i, int target){
        if (target < 0) return 0;
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        
      return dp[i][target] = solve(nums,i+1,target)+solve(nums,i+1,target-nums[i]);
        
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum=0;
        int n = arr.length;
        for(int i=0;i<n;i++) sum+=arr[i];
        if((sum + diff) % 2 != 0) return 0;
        if(diff > sum) return 0;
        dp=new int[n+1][((sum+diff)/2)+1];
        for(int i = 0; i <= n; i++)
    Arrays.fill(dp[i], -1);
        return solve(arr,0,(sum+diff)/2);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
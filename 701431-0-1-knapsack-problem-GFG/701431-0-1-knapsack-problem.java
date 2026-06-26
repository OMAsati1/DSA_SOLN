class Solution {
    int[][] dp;
    int rec(int idx, int W, int val[], int wt[]){
        if(idx==wt.length) return 0;
        if(dp[idx][W] != -1) return dp[idx][W];    
        int skip = rec(idx+1,W,val,wt);
        int take = Integer.MIN_VALUE;
        if(W-wt[idx]>=0) take = val[idx] + rec(idx+1,W-wt[idx],val,wt);
        return dp[idx][W] = Math.max(skip,take);
        
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        dp = new int[val.length+1][W+1];
        for(int[] row : dp) Arrays.fill(row, -1);
       return rec(0,W,val,wt);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
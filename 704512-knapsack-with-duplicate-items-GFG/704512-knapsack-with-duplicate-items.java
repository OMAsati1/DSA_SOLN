class Solution {
    int[][] dp;
    int rec(int idx, int W, int val[], int wt[]) {
        if(idx == wt.length) return 0;
        int skip = rec(idx+1, W, val, wt);
        int take = 0;
        if(W - wt[idx] >= 0) take = val[idx] + rec(idx, W-wt[idx], val, wt);
        return Math.max(skip, take);
    }
    
    int memo(int idx, int W, int val[], int wt[]){
        if(idx==wt.length) return 0;
        if(dp[idx][W] != -1) return dp[idx][W];    
        int skip = memo(idx+1,W,val,wt);
        int take = Integer.MIN_VALUE;
        if(W-wt[idx]>=0) take = val[idx] + memo(idx,W-wt[idx],val,wt);
        return dp[idx][W] = Math.max(skip,take);
        
    }
    public int knapSack(int val[], int wt[], int W) {
        // return rec(0, capacity, val, wt);
        dp = new int[val.length+1][W+1];
        for(int[] row : dp) Arrays.fill(row, -1);
       return memo(0,W,val,wt);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
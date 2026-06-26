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
    int tab(int W, int val[], int wt[]){
        int n = val.length;
        dp = new int[n+1][W+1];
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=W;j++){
               int skip = dp[i+1][j];
        int take = Integer.MIN_VALUE;
        if(j-wt[i]>=0) take = val[i] +dp[i+1][j-wt[i]]; 
        dp[i][j] = Math.max(skip,take);
            }
        }
        return dp[0][W];
    }
    
    int spcOpt(int W, int val[], int wt[]){
        int n = val.length;
        int[] next = new int[W+1];
        
        for(int i=n-1;i>=0;i--){
            int[] cur = new int[W+1];
            for(int j=0;j<=W;j++){
               int skip = next[j];
        int take = Integer.MIN_VALUE;
        if(j-wt[i]>=0) take = val[i] +next[j-wt[i]]; 
        cur[j] = Math.max(skip,take);
            }
            next = cur;
        }
        return next[W];
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        /*dp = new int[val.length+1][W+1];
        for(int[] row : dp) Arrays.fill(row, -1);
       return rec(0,W,val,wt);*/
    //   return tab(W,val,wt);
    return spcOpt(W,val,wt);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
class Solution {
    int solve(int[] cumSum, int l, int r, int[][] dp){
        if(r<=l) return 0;
        if(dp[l][r]!=-1) return dp[l][r];

        int ans = -1;
        for(int mid=l;mid<r;mid++){
            int leftSum = cumSum[mid] - (l-1>=0 ? cumSum[l-1] : 0);
            int rightSum = cumSum[r]-cumSum[mid];

            if(leftSum>rightSum){
                ans = Math.max(ans,rightSum+solve(cumSum,mid+1,r,dp));
            }
            else if(leftSum<rightSum){
                ans = Math.max(ans,leftSum+solve(cumSum,l,mid,dp));
            }
            else{
                ans = Math.max(ans,Math.max(leftSum+solve(cumSum,l,mid,dp),rightSum+solve(cumSum,mid+1,r,dp)));
            }
        }
        dp[l][r] = ans;
        return ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] cumSum = new int[n];
        cumSum[0]=stoneValue[0];
        for(int i=1;i<n;i++){
            cumSum[i]=cumSum[i-1]+stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(cumSum,0,n-1,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
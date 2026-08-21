class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] cumSum = new int[n];
        cumSum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            cumSum[i] = cumSum[i-1] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        for(int len=1; len<n; len++){
            for(int l=0; l+len<n; l++){
                int r = l+len;
                int ans = -1;

                for(int mid=l; mid<r; mid++){
                    int leftSum = cumSum[mid] - (l-1>=0 ? cumSum[l-1] : 0);
                    int rightSum = cumSum[r] - cumSum[mid];

                    if(leftSum>rightSum){
                        ans = Math.max(ans, rightSum + dp[mid+1][r]);
                    }
                    else if(leftSum<rightSum){
                        ans = Math.max(ans, leftSum + dp[l][mid]);
                    }
                    else{
                        ans = Math.max(ans, Math.max(leftSum + dp[l][mid], rightSum + dp[mid+1][r]));
                    }
                }
                dp[l][r] = ans;
            }
        }

        return dp[0][n-1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
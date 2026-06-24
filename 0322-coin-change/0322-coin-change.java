class Solution {
    int[][] dp; 

    int rec(int[] coins,int idx, int amount){
        if(amount==0) return 0;
        if(idx<0) return (int)1e9;
        int skip = rec(coins,idx-1,amount);
        int take = Integer.MAX_VALUE;
        if(amount-coins[idx]>=0) take = 1 + rec(coins,idx,amount-coins[idx]);
        return Math.min(take,skip);
    }

     int memo(int[] coins,int idx, int amount){
        if(amount==0) return 0;
        if(idx<0) return (int)1e9;
        if(dp[idx][amount]!=-1) return dp[idx][amount]; 
        int skip = memo(coins,idx-1,amount);
        int take = Integer.MAX_VALUE;
        if(amount-coins[idx]>=0) take = 1 + memo(coins,idx,amount-coins[idx]);
        return dp[idx][amount] = Math.min(take,skip);
    }

    int tab(int[] coins, int amount){
        int n = coins.length;
        int INF = (int)1e9;

        int[][] dp = new int[n][amount + 1];

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = INF;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {

                int skip = dp[i - 1][j];

                int take = INF;
                if (j >= coins[i])
                    take = 1 + dp[i][j - coins[i]];

                dp[i][j] = Math.min(skip, take);
            }
        }

        int ans = dp[n - 1][amount];
        return ans >= INF ? -1 : ans;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // return rec(coins,n-1,amount) == (int)1e9 ? -1 : rec(coins,n-1,amount);
        
        /* dp = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return memo(coins,n-1,amount) == (int)1e9 ? -1 : memo(coins,n-1,amount); */
    return tab(coins,amount);

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
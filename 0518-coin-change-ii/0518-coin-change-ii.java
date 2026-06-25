class Solution {
    int[][] dp;
    int rec(int[] coins,int idx, int amount){
        if(amount==0) return 1;
        if(idx<0) return 0;
        int skip = rec(coins,idx-1,amount);
        int take = 0;
        if(amount-coins[idx]>=0) take = rec(coins,idx,amount-coins[idx]);
        return skip+take;
    }

    int memo(int[] coins,int idx, int amount){
        if(amount==0) return 1;
        if(idx<0) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount]; 
        int skip = memo(coins,idx-1,amount);
        int take = 0;
        if(amount-coins[idx]>=0) take = memo(coins,idx,amount-coins[idx]);
        return dp[idx][amount] = skip+take;
    }

    int tab(int amount, int[] coins){
        int n = coins.length;
        dp = new int[n][amount+1];

        for(int i=0;i<n;i++) dp[i][0]=1;

        for(int i=0;i<n;i++){
            for(int a = 1;a<=amount;a++){
               int skip = (i > 0) ? dp[i - 1][a] : 0;

            int take = 0;
            if (a >= coins[i])
                take = dp[i][a - coins[i]];

            dp[i][a] = skip + take;  
            }
        }
        return dp[n - 1][amount];
    }

    int spcOpt(int amount, int[] coins){
        int n = coins.length;
        int[] prev = new int[amount+1];

        // prev[0]=1;

        for(int i=0;i<n;i++){
            int[] curr = new int[amount+1];
            curr[0] = 1;
            for(int a = 1;a<=amount;a++){
               int skip = prev[a];

            int take = 0;
            if (a >= coins[i])
                take = curr[a - coins[i]];

            curr[a] = skip + take;  
            }
            prev=curr;
        }
        return prev[amount];
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // return rec(coins,n-1,amount) == (int)1e9 ? 0 : rec(coins,n-1,amount);

       /*  dp = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return memo(coins,n-1,amount) == (int)1e9 ? -1 : memo(coins,n-1,amount);  */

        // return tab(amount,coins);
        return spcOpt(amount,coins);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
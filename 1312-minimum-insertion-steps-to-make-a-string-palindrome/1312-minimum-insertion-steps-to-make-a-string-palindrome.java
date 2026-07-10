class Solution {
    int[][] dp;
    int rec(int i, int j, String s){
        if(i>=j) return 0;
         
         if(dp[i][j]!=-1) return dp[i][j];

         if(s.charAt(i)==s.charAt(j)) return dp[i][j] = rec(i+1,j-1,s);

         return dp[i][j] = 1 + Math.min(rec(i+1,j,s),rec(i,j-1,s));
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(var row : dp) Arrays.fill(row,-1);
        return rec(0,n-1,s);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
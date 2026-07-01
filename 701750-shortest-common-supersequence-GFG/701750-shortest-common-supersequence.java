class Solution {
    
    static int[][] dp;
    
   static int rec(int i, int j, String s1, String s2) {

        // s1 finished
        if (i == s1.length())
            return s2.length() - j;

        // s2 finished
        if (j == s2.length())
            return s1.length() - i;

        if (s1.charAt(i) == s2.charAt(j))
            return 1 + rec(i + 1, j + 1, s1, s2);

        return 1 + Math.min(
                rec(i + 1, j, s1, s2), // take s1[i]
                rec(i, j + 1, s1, s2)  // take s2[j]
        );
    }
    
    static int memo(int i, int j, String s1, String s2) {


        if (i == s1.length())
            return s2.length() - j;
            
        if (j == s2.length())
            return s1.length() - i;
            
            if(dp[i][j]!=-1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
         return dp[i][j] = 1 + memo(i + 1, j + 1, s1, s2);

        return dp[i][j] = 1 + Math.min(
                memo(i + 1, j, s1, s2), // take s1[i]
                memo(i, j + 1, s1, s2)  // take s2[j]
        );
    }
    
    public static int minSuperSeq(String s1, String s2) {
        // code here
        // return rec(0, 0, s1, s2);
        int n = s1.length(),m = s2.length();
        
        dp = new int[n][m];
        for(var arr : dp) Arrays.fill(arr,-1);
        return memo(0, 0, s1, s2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
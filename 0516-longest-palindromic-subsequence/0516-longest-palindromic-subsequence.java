class Solution {
    int[][] dp;

    int rec(int i, int j, String s) {

        if (i > j)
            return 0;

        if (i == j)
            return 1;

        if (s.charAt(i) == s.charAt(j))
            return 2 + rec(i + 1, j - 1, s);

        return Math.max(
                rec(i + 1, j, s),
                rec(i, j - 1, s)
        );
    }

    int memo(int i, int j, String s) {

        if (i > j)
            return 0;

        if (i == j)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = 2 + memo(i + 1, j - 1, s);

        return dp[i][j] = Math.max(
                memo(i + 1, j, s),
                memo(i, j - 1, s)
        );
    }

    int tab(String s){
         int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

            for (int i = n - 1; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];

    }

    public int longestPalindromeSubseq(String s) {
        // return rec(0, s.length() - 1, s);

        // int n = s.length();
        // dp = new int[n][n];

        // for (int i = 0; i < n; i++)
        //     Arrays.fill(dp[i], -1);

        // return memo(0, n - 1, s);

        return tab(s);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
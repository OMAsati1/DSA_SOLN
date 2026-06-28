class Solution {
    static int[][]dp;
    static int rec(int i, int j, String s1, String s2){

    if(i == s1.length() || j == s2.length())
        return 0;

    if(s1.charAt(i) == s2.charAt(j))
        return 1 + rec(i+1, j+1, s1, s2);

    return Math.max(
            rec(i+1, j, s1, s2),
            rec(i, j+1, s1, s2)
    );
}

static int tab(String s1, String s2){
    int n = s1.length();
        int m = s2.length();

        int[] next = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {

            int[] curr = new int[m + 1];

            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j))
                    curr[j] = 1 + next[j + 1];
                else
                    curr[j] = Math.max(next[j], curr[j + 1]);

            }

            next = curr;
        }

        return next[0];

}

static int memo(int i, int j, String s1, String s2) {

        if (i == s1.length() || j == s2.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + memo(i + 1, j + 1, s1, s2);

        return dp[i][j] = Math.max(
                memo(i + 1, j, s1, s2),
                memo(i, j + 1, s1, s2)
        );
    }

    static int lcs(String s1, String s2) {

        /*int n = s1.length();
        int m = s2.length();

        dp = new int[n][m];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return memo(0, 0, s1, s2);*/
        return tab(s1,s2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
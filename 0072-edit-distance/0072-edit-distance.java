class Solution {

    int[][] dp;

    int rec(int i, int j, String word1, String word2) {

        if (i == word1.length())
            return word2.length() - j;

        if (j == word2.length())
            return word1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j] = rec(i + 1, j + 1, word1, word2);

        int delete = rec(i + 1, j, word1, word2);
        int insert = rec(i, j + 1, word1, word2);
        int replace = rec(i + 1, j + 1, word1, word2);

        return dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
    }

    int tab(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        dp = new int[n + 1][m + 1];

        // Base cases
        for (int j = 0; j <= m; j++)
            dp[n][j] = m - j;

        for (int i = 0; i <= n; i++)
            dp[i][m] = n - i;

        // Fill from bottom-right
        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {

                    int delete = dp[i + 1][j];
                    int insert = dp[i][j + 1];
                    int replace = dp[i + 1][j + 1];

                    dp[i][j] = 1 + Math.min(delete,
                                    Math.min(insert, replace));
                }
            }
        }

        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {

        // dp = new int[word1.length()][word2.length()];

        // for (int[] row : dp)
        //     Arrays.fill(row, -1);

        // return rec(0, 0, word1, word2);

        return tab(word1,word2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
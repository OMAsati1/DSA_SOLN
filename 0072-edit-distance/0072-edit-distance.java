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

    public int minDistance(String word1, String word2) {

        dp = new int[word1.length()][word2.length()];

        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        return rec(0, 0, word1, word2);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
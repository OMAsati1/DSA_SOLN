class Solution {

    int[][] dp;

    boolean isPalindrome(String s, int i, int j) {

        if (i >= j)
            return true;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = 0;
            return false;
        }

        boolean ans = isPalindrome(s, i + 1, j - 1);
        dp[i][j] = ans ? 1 : 0;

        return ans;
    }

    public int countSubstrings(String s) {

        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isPalindrome(s, i, j))
                    count++;
            }
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
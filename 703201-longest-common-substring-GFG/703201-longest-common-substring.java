class Solution {
    public int longCommSubstr(String s1, String s2) {


       int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // dp[n][*] = 0 and dp[*][m] = 0
        // Already initialized to 0 in Java.
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else
                    dp[i][j] = 0;

            }
        }

        return ans;
    }
}
    

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
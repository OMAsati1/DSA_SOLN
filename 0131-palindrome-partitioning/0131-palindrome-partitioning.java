class Solution {

    void solve(String s, int i, List<List<String>> ans,
               List<String> curr, boolean[][] dp) {

        if (i == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            if (dp[i][j]) {

                curr.add(s.substring(i, j + 1));

                solve(s, j + 1, ans, curr, dp);

                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Length = 1
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        // Length >= 2
        for (int L = 2; L <= n; L++) {

            for (int i = 0; i + L - 1 < n; i++) {

                int j = i + L - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (L == 2)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();

        solve(s, 0, ans, new ArrayList<>(), dp);

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
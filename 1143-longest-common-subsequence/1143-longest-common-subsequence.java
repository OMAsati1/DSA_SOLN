class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
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
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
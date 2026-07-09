class Solution {

    int expand(String s, int l, int r) {

        if (l < 0 || r >= s.length())
            return 0;

        if (s.charAt(l) != s.charAt(r))
            return 0;

        // Current substring is a palindrome
        return 1 + expand(s, l - 1, r + 1);
    }

    public int countSubstrings(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindromes
            ans += expand(s, i, i);

            // Even length palindromes
            ans += expand(s, i, i + 1);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
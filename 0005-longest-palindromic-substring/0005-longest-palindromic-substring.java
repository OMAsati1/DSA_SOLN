class Solution {

    int start = 0;
    int maxLen = 0;

    void expand(String s, int l, int r) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }

            l--;
            r++;
        }
    }

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            expand(s, i, i);

            // Even length palindrome
            expand(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
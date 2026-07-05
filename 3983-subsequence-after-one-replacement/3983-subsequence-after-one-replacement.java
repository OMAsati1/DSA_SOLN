class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length();
        for (int k = 0; k < t.length(); k++) {
            char c = t.charAt(k);
            j = Math.max(j + (j < n && c == s.charAt(j) ? 1 : 0), i + 1);
            i += (i < n && c == s.charAt(i) ? 1 : 0);
        }
        return j >= n;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
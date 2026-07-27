class Solution {
    public int largestInteger(int n, int s) {
        if (s > 9 * n) return -1;
        if (s == 0) return 0;

        int ans = 0;
        while (n-- > 0) {
            int d = Math.min(9, s);
            ans = ans * 10 + d;
            s -= d;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
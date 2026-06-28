class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n + 1];

        for (int x : arr) {
            freq[Math.min(x, n)]++;
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans + freq[i], i);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
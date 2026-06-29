class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long NEG = -(long) 1e18;
        long ans = NEG;

        // ---------------- Multiply (Only 2 states) ----------------
        long dp0 = 0;
        long dp1 = NEG;

        for (int x : nums) {

            long val = (long) x * k;

            long ndp0 = Math.max(0L, dp0) + x;
            long ndp1 = Math.max(Math.max(0L, dp0), dp1) + val;

            ans = Math.max(ans, ndp1);

            dp0 = ndp0;
            dp1 = ndp1;
        }

        // ---------------- Divide (3 states) ----------------
        dp0 = 0;
        dp1 = NEG;
        long dp2 = NEG;

        for (int x : nums) {

            long val = (x >= 0) ? x / k : -((-x) / k);

            long ndp0 = Math.max(0L, dp0) + x;
            long ndp1 = Math.max(Math.max(0L, dp0), dp1) + val;
            long ndp2 = Math.max(dp1, dp2) + x;

            ans = Math.max(ans, Math.max(ndp1, ndp2));

            dp0 = ndp0;
            dp1 = ndp1;
            dp2 = ndp2;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna
class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        long NEG = -(long) 1e18;
        long ans = NEG;

        // ---------------- Multiply ----------------
        long dp0 = 0;
        long dp1 = NEG;
        long dp2 = NEG;

        for (int x : nums) {

            long val = (long) x * k;

            long ndp0 = Math.max(0L, dp0) + x;
            long ndp1 = Math.max(Math.max(0L, dp0), dp1) + val;
            long ndp2 = Math.max(dp1, dp2) + x;

            ans = Math.max(ans, Math.max(ndp1, ndp2));

            dp0 = ndp0;
            dp1 = ndp1;
            dp2 = ndp2;
        }

        // ---------------- Divide ----------------
        dp0 = 0;
        dp1 = NEG;
        dp2 = NEG;

        for (int x : nums) {

            long val;
            if (x >= 0)
                val = x / k;
            else
                val = -((-x) / k);   // ceil(x/k)

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
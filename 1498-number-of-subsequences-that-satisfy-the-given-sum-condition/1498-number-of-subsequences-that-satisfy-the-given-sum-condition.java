class Solution {

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        int MOD = 1_000_000_007;

        // pow[i] = 2^i % MOD
        int[] pow = new int[n];
        pow[0] = 1;

        for (int i = 1; i < n; i++)
            pow[i] = (pow[i - 1] * 2) % MOD;

        int i = 0;
        int j = n - 1;

        long ans = 0;

        while (i <= j) {

            if (nums[i] + nums[j] <= target) {

                ans = (ans + pow[j - i]) % MOD;
                i++;

            } else {

                j--;
            }
        }

        return (int) ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna